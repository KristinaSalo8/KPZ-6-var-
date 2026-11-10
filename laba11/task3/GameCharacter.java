package task3_decorator;

/** Роль: Component - інтерфейс, з яким працює бойова система. */
public interface GameCharacter {
    String getDescription();
    int getAttack();
    int getDefense();
    int getSpeed();
}
