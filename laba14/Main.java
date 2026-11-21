import task1.Situation1;
import task2.Situation2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Observer (система досягнень): ");
        Situation1.run();
        System.out.println("\nMediator (торгівля між гравцями): ");
        Situation2.run();
    }
}
