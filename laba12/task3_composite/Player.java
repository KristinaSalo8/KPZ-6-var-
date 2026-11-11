package task3_composite;

import common.Logger;

/** Роль: Leaf - окремий гравець. */
public class Player implements GuildUnit {
    private final String name;
    private final int power;
    private int reward = 0;

    public Player(String name, int power) {
        this.name = name;
        this.power = power;
    }

    @Override public String getName() { return name; }

    @Override public int getPower() { return power; }

    @Override public int getMemberCount() { return 1; }

    @Override public void distributeReward(int amount) {
        reward += amount;
        Logger.log("Player", name + " отримує " + amount + " (усього: " + reward + ")");
    }

    @Override public void print(String indent) {
        System.out.println(indent + "Гравець «" + name + "» [сила " + power + "]");
    }
}
