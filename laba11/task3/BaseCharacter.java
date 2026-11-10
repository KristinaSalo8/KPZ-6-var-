package task3_decorator;

/** Роль: ConcreteComponent - конкретна реалізація персонажа без ефектів. */
public class BaseCharacter implements GameCharacter {
    private final String name;
    private final int attack, defense, speed;

    public BaseCharacter(String name, int attack, int defense, int speed) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    @Override public String getDescription() { return name; }
    @Override public int getAttack() { return attack; }
    @Override public int getDefense() { return defense; }
    @Override public int getSpeed() { return speed; }
}
