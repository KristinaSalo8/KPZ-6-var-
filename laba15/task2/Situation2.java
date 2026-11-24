package task2;
public class Situation2 {
    public static void run() {
        new Cave().run("Ярослав", 5);
        System.out.println();
        new IceCastle().run("Олена", 3);
        new IceCastle().run("Олена", 10);
        System.out.println();
        new Swamp().run("Ярослав", 5);
    }
}