package task1_prototype;

// Вкладений об'єкт - екіпірування (глобальне копіювання/deep copy)
// Deep copy (глибоке копіювання) - створює новий об'єкт і копіює значення всіх полів, включаючи вкладені об'єкти.
public class Weapon {
    private String name;
    private int damage;
    public Weapon(String name, int damage) { this.name = name; this.damage = damage; }
    public Weapon(Weapon other) { this(other.name, other.damage); }
    
    @Override public String toString() { return name + "(" + damage + ")"; }
    public void setName(String name) {
        this.name = name;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
