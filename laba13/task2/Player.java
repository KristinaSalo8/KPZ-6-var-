package task2;

/** Паттерн Chain of Responsibility дозволяє винести кожну перевірку в окремий клас-обробник
 * і збирати з них потрібний ланцюг динамічно під час виконання програми
 * Гравець - відправник повідомлення. */
public class Player {
    private final String name;
    private final boolean muted;

    public Player(String name, boolean muted) {
        this.name = name;
        this.muted = muted;
    }

    public String getName() { return name; }

    public boolean isMuted() { return muted; }
}
