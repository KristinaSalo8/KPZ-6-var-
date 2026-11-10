import task1.Situation1;
import task2.Situation2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Facade (вхід гравця у світ):");
        Situation1.run();
        System.out.println("\nAdapter (стороння платіжна система): ");
        Situation2.run();
        System.out.println("\nDecorator (ефекти на персонажі)");
        Situation3.run();
        System.out.println("\nProxy (завантаження локацій)");
        Situation4.run();
    }
}