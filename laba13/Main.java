import task1.Situation1;
import task2.Situation2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Command (дії гравця і повтор бою): ");
        Situation1.run();
        System.out.println("\nChain of Responsibility (фільтри чату): ");
        Situation2.run();
    }
}