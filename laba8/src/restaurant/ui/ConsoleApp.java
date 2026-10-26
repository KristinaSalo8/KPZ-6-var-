package restaurant.ui;

import restaurant.application.ReservationController;
import restaurant.application.ReservationFactory;
import restaurant.application.ReservationRepository;
import restaurant.infrastructure.FileReservationRepository;
import restaurant.infrastructure.NotifyingReservationRepository;
import restaurant.infrastructure.SmsNotificationService;

import java.util.Scanner;
public class ConsoleApp {
    public static void main(String[] args) {
        ReservationRepository repository = new NotifyingReservationRepository(
                new FileReservationRepository("reservations.json"),
                new SmsNotificationService());
        ReservationController controller =
                new ReservationController(new ReservationFactory(), repository);
        ConsoleCommandParser parser = new ConsoleCommandParser();
        ReservationReceiptFormatter formatter = new ReservationReceiptFormatter();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Бронювання столика в ресторані ===");
            System.out.print("Введіть ім'я гостя: ");
            String name = scanner.nextLine();
            System.out.print("Введіть час відвідування (HappyHours/Standard/Evening): ");
            String slot = scanner.nextLine();
            System.out.print("Введіть кількість гостей: ");
            String guests = scanner.nextLine();

            System.out.println(formatter.format(controller.reserve(parser.parse(name, slot, guests))));
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
