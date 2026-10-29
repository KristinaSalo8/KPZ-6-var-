package restaurant.infrastructure;
import restaurant.application.ReservationRepository;
import restaurant.domain.TableReservation;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Locale;
//Pure Fabrication (Штучна фабрикація) - Клас, який не є частиною предметної області,
//але створений для виконання певної задачі (збереження даних у файл), що дозволяє зберегти чистоту предметної області.
public class FileReservationRepository implements ReservationRepository {
    private final Path file;
    public FileReservationRepository(String fileName) {
        this.file = Path.of(fileName);
    }
    @Override
    public void save(TableReservation r) {
        String line = String.format(Locale.ROOT,"{\"id\":%d,\"guest\":\"%s\",\"guests\":%d,\"total\":%.2f}%n",r.id(), r.guestName(), r.guestsCount(), r.totalBill());
        try {
            Files.writeString(file, line, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new UncheckedIOException("Не вдалося зберегти бронювання", e);
        }
        System.out.println("[БД Ресторану] Бронювання #" + r.id() + " збережено в " + file + ".");
    }
}
