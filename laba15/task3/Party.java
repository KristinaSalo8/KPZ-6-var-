package task3;

import common.Logger;
import java.util.List;

/** Context: загін. Правило розподілу можна змінити в будь-який момент; сам код загону не змінюється */
public class Party {
    private final String name;
    private final List<Member> members;
    private LootStrategy strategy;

    public Party(String name, List<Member> members, LootStrategy strategy) {
        this.name = name;
        this.members = members;
        this.strategy = strategy;
    }

    /** Лідер (перший учасник) змінює правило */
    public void setStrategy(LootStrategy next) {
        Logger.log(members.get(0).getName(), "Лідер змінює правило розподілу: «" + strategy.getName() + "» → «" + next.getName() + "»");
        strategy = next;
    }

    public void distribute(List<Item> items) {
        Logger.log(name, "Розподіл " + items.size() + " предметів між " + members.size() + " гравцями");
        for (Item item : items) {
            Member m = strategy.choose(item, members);
            m.addLoot(item);
            Logger.log("Правило «" + strategy.getName() + "»", item.getName() + " → " + m.getName());
        }
    }

    public void printLoot() {
        for (Member m : members) System.out.println("  " + m);
    }
}
