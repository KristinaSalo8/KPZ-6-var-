package task3_composite;

import common.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 * Роль: Composite - загін, гільдія або альянс (один клас, різниця лише у виді).
 * Сила і кількість рахуються рекурсивно, тому глибина вкладеності не має значення.
 */
public class Group implements GuildUnit {
    private final String kind;
    private final String name;
    private final List<GuildUnit> children = new ArrayList<>();

    public Group(String kind, String name) {
        this.kind = kind;
        this.name = name;
    }

    public Group add(GuildUnit unit) {
        children.add(unit);
        return this;
    }

    @Override public String getName() { return name; }

    @Override public int getPower() {
        int sum = 0;
        for (GuildUnit c : children) sum += c.getPower();
        return sum;
    }

    @Override public int getMemberCount() {
        int sum = 0;
        for (GuildUnit c : children) sum += c.getMemberCount();
        return sum;
    }

    /** Нагорода ділиться порівну на кожного гравця: вузол передає дітям частку за кількістю їхніх учасників. */
    @Override public void distributeReward(int amount) {
        Logger.log(kind + " «" + name + "»", "Розподіл нагороди " + amount + " між " + getMemberCount() + " гравцями");
        for (GuildUnit c : children) {
            c.distributeReward(amount * c.getMemberCount() / getMemberCount());
        }
    }

    @Override public void print(String indent) {
        System.out.println(indent + kind + " «" + name + "» [сила " + getPower()
                + ", учасників " + getMemberCount() + "]");
        for (GuildUnit c : children) c.print(indent + "    ");
    }
}
