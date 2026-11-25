import task1.Situation1;
import task2.Situation2;
import task3.Situation3;

public class Main {
    public static void main(String[] args) {
        System.out.println("State (поведінка монстра): ");
        Situation1.run();
        System.out.println("\nTemplate Method (проходження підземель):");
        Situation2.run();
        System.out.println("\nStrategy (розподіл здобичі): ");
        Situation3.run();
    }
}
