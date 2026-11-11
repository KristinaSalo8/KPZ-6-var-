import task1.Situation1;
import task2_flyweight.Situation2;
import task3_composite.Situation3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bridge (уміння і стихії):");
        Situation1.run();
        System.out.println("\n Ситуація 2: Flyweight (рослинність на мапі): ");
        Situation2.run();
        System.out.println("\n Ситуація 3: Composite (гільдії і загони): ");
        Situation3.run();
    }
}