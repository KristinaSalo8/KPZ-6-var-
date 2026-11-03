package task1;

//ConcreteCreator - початкові типи локацій
public final class Locations {
    private Locations() { }
    public static class Forest extends Location {
        public Forest() { super("Ліс", "Галявина", "Узлісся"); }
        @Override protected Monster createMonster() { return new Monsters.Wolf(); }
    }
    public static class Swamp extends Location {
        public Swamp() { super("Болото", "Трясовина", "Острівець"); }
        @Override protected Monster createMonster() { return new Monsters.Vampire(); }
    }
    public static class Mountains extends Location {
        public Mountains() { super("Гори", "Перевал", "Печера"); }
        @Override protected Monster createMonster() { return new Monsters.Troll(); }
    }
}
