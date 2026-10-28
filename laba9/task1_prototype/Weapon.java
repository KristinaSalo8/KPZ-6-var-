package task1_prototype;

// Вкладений об'єкт - екіпірування (глобальне копіювання/deep copy)
public class Weapon {
    String name;
    int damage;
    public Weapon(String name, int damage) { this.name = name; this.damage = damage; }
    public Weapon(Weapon other) { this(other.name, other.damage); }
    @Override public String toString() { return name + "(" + damage + ")"; }
}
