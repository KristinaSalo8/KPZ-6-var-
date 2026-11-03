package task1;

//Product (абстрактний продукт).
public abstract class Monster {
    private final String name;
    private final int hp;
    private final String ability;
    protected Monster(String name, int hp, String ability) {
        this.name = name;
        this.hp = hp;
        this.ability = ability;
    }
    public String getName() { return name; }
    @Override public String toString() { return name + " [HP " + hp + ", вміння: " + ability + "]"; }
}
