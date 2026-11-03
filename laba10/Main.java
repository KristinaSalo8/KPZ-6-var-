import task1.Situation1;
import task2.Situation2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Factory Method (спавн монстрів):");
        Situation1.run();
        System.out.println("Abstract Factory (стартове спорядження фракцій):");
        Situation2.run();
    }
}