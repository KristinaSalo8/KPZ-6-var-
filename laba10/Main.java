import task1.Situation1;
import task2.Situation2;
import task3.Situation3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Factory Method (спавн монстрів):");
        Situation1.run();
        System.out.println("Abstract Factory (стартове спорядження фракцій):");
        Situation2.run();
        System.out.println("Builder (створення персонажів):");
        Situation3.run();
    }
}