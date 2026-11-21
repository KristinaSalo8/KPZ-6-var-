package task2_mediator;

import java.util.List;

/** Пропозиція гравця: предмети й золото. */
public class Offer {
    private final List<String> items;
    private final int gold;

    public Offer(List<String> items, int gold) {
        this.items = List.copyOf(items);
        this.gold = gold;
    }

    public List<String> getItems() { return items; }

    public int getGold() { return gold; }

    @Override public String toString() { return "предмети " + items + ", золото " + gold; }
}
