package task3_composite;

/** Роль: Component - спільний інтерфейс для гравця і будь-якого об'єднання. */
public interface GuildUnit {
    String getName();

    int getPower();

    int getMemberCount();

    void distributeReward(int amount);

    void print(String indent);
}
