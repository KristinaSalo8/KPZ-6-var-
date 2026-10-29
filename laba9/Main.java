import task1_prototype.Situation1;
import task2_singleton.Situation2;
import task3_pool.Situation3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ситуація 1: Prototype (монстри):");
        Situation1.run();
        System.out.println("\nСитуація 2: Singleton (ігровий час):");
        Situation2.run();
        System.out.println("\nСитуація 3: Object Pool (арени):");
        Situation3.run();
    }
}
