package task1;

// Поведінка гравця або противника
public class Fighter {
    private final String name;
    private final int maxHp;
    private int hp;
    private int position;
    private int potions;
    public Fighter(String name, int hp, int potions) {
        this.name = name;
        this.maxHp = hp;
        this.hp = hp;
        this.potions = potions;
    }
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getPosition() { return position; }
    public int getPotions() { return potions; }
    public void moveBy(int dx) { position += dx; }
    // Повертає завдану шкоду (HP не опускається нижче 0)
    public int takeDamage(int damage) {
        int dealt = Math.min(damage, hp);
        hp -= dealt;
        return dealt;
    }

    // Повертає відновлене HP (не вище максимуму)
    public int heal(int amount) {
        int healed = Math.min(amount, maxHp - hp);
        hp += healed;
        return healed;
    }
    public void addPotions(int n) { potions += n; }
    @Override public String toString() {
        return name + " [HP " + hp + "/" + maxHp + ", позиція " + position + ", зілля " + potions + "]";
    }
}