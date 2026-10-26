import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

// Автоматизована система міської бібліотеки
// (SRP): клас повинен мати лише одну причину зміни
public class Task1_SRP {
    // ! Dont Repeat Yourself (DRY): формати дат - константи, а не створюються щоразу заново
    static final DateTimeFormatter UI_DATE = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    static final DateTimeFormatter DB_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    // Доменна модель     
    record BookReturnModel(String readerTicketNumber, String readerName, String readerEmail,
                           String bookIsbn, String bookTitle,
                           LocalDate expectedReturnDate, LocalDate actualReturnDate) { } // Збереження даних про повернення книги

    record ReturnResult(long overdueDays, BigDecimal fine, int loyaltyPoints) {
        boolean isOverdue() { return overdueDays > 0; } // Зберігає результати обчислень
    }
    // Відповідальність 1: валідація - перевіряє коректність даних (Guard Clauses)
    static class LoanValidator {
        void validate(BookReturnModel loan) {
            Objects.requireNonNull(loan, "loan не може бути null");
            if (isBlank(loan.readerTicketNumber()))
                throw new IllegalArgumentException("Номер читацького квитка відсутній.");
            if (isBlank(loan.bookIsbn()))
                throw new IllegalArgumentException("Код ISBN книги обов'язковий.");
            Objects.requireNonNull(loan.expectedReturnDate(), "Планова дата відсутня");
            Objects.requireNonNull(loan.actualReturnDate(), "Фактична дата відсутня");
            if (loan.actualReturnDate().isBefore(loan.expectedReturnDate().minusYears(1)))
                throw new IllegalStateException("Неможлива дата повернення книги.");
        }
        private boolean isBlank(String s) { return s == null || s.isBlank(); }
    }
    // Відповідальність 2: бізнес-правила - обчислює штрафи та бали 
    static class FineCalculator {
        private static final BigDecimal FINE_PER_DAY = new BigDecimal("15.00"); // (DRY) єдине місце визначення
        private static final int ON_TIME_POINTS = 10;

        ReturnResult calculate(BookReturnModel loan) {
            long days = ChronoUnit.DAYS.between(loan.expectedReturnDate(), loan.actualReturnDate());
            if (days > 0) {
                return new ReturnResult(days, FINE_PER_DAY.multiply(BigDecimal.valueOf(days)), 0);
            }
            return new ReturnResult(0, BigDecimal.ZERO, ON_TIME_POINTS);
        }
    }
    // Відповідальність 3: форматування тексту
    static class NoticeFormatter {
        String subject(ReturnResult r) {
            return r.isOverdue() ? "Повідомлення про штраф за прострочення книги"
                                 : "Підтвердження повернення книги";
        }
        String body(BookReturnModel loan, ReturnResult r) {
            StringBuilder sb = new StringBuilder("БІБЛІОТЕЧНИЙ АКТ ПОВЕРНЕННЯ КНИГИ\n");
            sb.append("Читач: ").append(loan.readerName())
              .append(" (Квиток №").append(loan.readerTicketNumber()).append(")\n");
            sb.append("Книга: \"").append(loan.bookTitle()).append("\" (ISBN: ").append(loan.bookIsbn()).append(")\n");
            sb.append("Планова дата: ").append(loan.expectedReturnDate().format(UI_DATE))
              .append(" | Фактична: ").append(loan.actualReturnDate().format(UI_DATE)).append("\n");
            if (r.isOverdue()) {
                sb.append(String.format("УВАГА! Прострочення: %d днів. Штраф до сплати: %.2f грн.%n",
                        r.overdueDays(), r.fine()));
            } else {
                sb.append("Дякуємо за вчасне повернення! Нараховано бонусних балів: ")
                  .append(r.loyaltyPoints()).append("\n");
            }
            return sb.toString();
        }
    }
    // Відповідальність 4: збереження у каталозі (файл) - оновлює статус книги
    static class FileCatalogRepository {
        private final String fileName;

        FileCatalogRepository(String fileName) { this.fileName = fileName; }

        void markReturned(BookReturnModel loan) {
            String record = String.format("%s|RETURNED|%s|By_%s%n", loan.bookIsbn(),
                    loan.actualReturnDate().format(DB_DATE), loan.readerTicketNumber());
            try (FileWriter writer = new FileWriter(fileName, true)) {
                writer.write(record);
            } catch (IOException e) {
                System.err.println("Помилка оновлення каталогу: " + e.getMessage());
            }
        }
    }
    // Відповідальність 5: надсилання сповіщення на пошту
    static class EmailNotifier {
        void send(String email, String subject, String text) {
            System.out.println("Надсилання пошти на " + email + " через smtp.citylibrary.local");
            System.out.println("Тема: " + subject);
            System.out.println("Текст: " + text);
        }
    }
    // Оркестратор - який просто викликає потрібні кроки один за одним
    static class LibraryLoanService {
        private final LoanValidator validator;
        private final FineCalculator calculator;
        private final NoticeFormatter formatter;
        private final FileCatalogRepository repository;
        private final EmailNotifier notifier;

        LibraryLoanService(LoanValidator validator, FineCalculator calculator, NoticeFormatter formatter,
                           FileCatalogRepository repository, EmailNotifier notifier) {
            this.validator = validator;
            this.calculator = calculator;
            this.formatter = formatter;
            this.repository = repository;
            this.notifier = notifier;
        }
        //Викликає їх у метод processBookReturn
        void processBookReturn(BookReturnModel loan) {
            validator.validate(loan);
            ReturnResult result = calculator.calculate(loan);
            String body = formatter.body(loan, result);
            repository.markReturned(loan);
            notifier.send(loan.readerEmail(), formatter.subject(result), body);
        }
    }
    public static void main(String[] args) {
        LibraryLoanService service = new LibraryLoanService(new LoanValidator(), new FineCalculator(),
                new NoticeFormatter(), new FileCatalogRepository("library_catalog_history.txt"), new EmailNotifier());

        LocalDate expected = LocalDate.of(2026, 10, 1);
        service.processBookReturn(new BookReturnModel("T-001", "Іваненко І.І.", "ivan@mail.ua",
                "978-966-03-1234-5", "Кобзар", expected, LocalDate.of(2026, 10, 8))); // прострочено
        service.processBookReturn(new BookReturnModel("T-002", "Петренко П.П.", "petro@mail.ua",
                "978-966-03-9999-1", "Intermezzo", expected, LocalDate.of(2026, 9, 30))); // вчасно
    }
}