package task1;

//ConcreteProduct - монстри для початкових локацій
public final class Monsters {
    private Monsters() { }
    public static class Wolf extends Monster {
        public Wolf() { super("Вовк", 40, "Вкус"); }
    }
    public static class Vampire extends Monster {
        public Vampire() { super("Упир", 70, "Висмоктування крові"); }
    }
    public static class Troll extends Monster {
        public Troll() { super("Троль", 120, "Удар булавою"); }
    }
}