package task1;

// Новий ConcreteCreator: локація «Пустеля»
public class WastelandLocation extends Location {
    public WastelandLocation() { super("Пустеля", "Бархан", "Оазис"); }
    @Override protected Monster createMonster() { return new Scorpion(); }
}
