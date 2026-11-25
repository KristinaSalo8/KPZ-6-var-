package task3;

import java.util.ArrayList;
import java.util.List;

/** Учасник загону */
public class Member {
    private final String name;
    private final String playerClass;
    private final int contribution;
    private final List<String> loot = new ArrayList<>();

    public Member(String name, String playerClass, int contribution) {
        this.name = name;
        this.playerClass = playerClass;
        this.contribution = contribution;
    }

    public String getName() { return name; }

    public String getPlayerClass() { return playerClass; }

    public int getContribution() { return contribution; }

    public int getLootCount() { return loot.size(); }

    public void addLoot(Item item) { loot.add(item.getName()); }

    @Override public String toString() {
        return name + " (" + playerClass + ", внесок " + contribution + "): " + loot;
    }
}
