package task4_proxy;

import common.Logger;

/** Роль: RealSubject - локація з великою мапою, що дорого завантажується. */
public class RealLocation implements Location {
    private final String name;

    public RealLocation(String name) {
        this.name = name;
        Logger.log("RealLocation:" + name, "Завантаження великої мапи (дорога операція)");
        Logger.sleep(300); // імітація дорогої операції
    }

    @Override public String getName() { return name; }

    @Override public boolean enter(Player player) {
        Logger.log("RealLocation:" + name, "Гравець " + player.name + " увійшов у локацію");
        return true;
    }
}
