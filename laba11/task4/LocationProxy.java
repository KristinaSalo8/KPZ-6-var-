package task4;

import common.Logger;

/**
 * Роль: Proxy. Перевіряє рівень гравця (захисний проксі) і створює справжню локацію
 * лише при першому вході (віртуальний проксі).
 */
public class LocationProxy implements Location {
    private final String name;
    private final int minLevel;
    private RealLocation real; // створюється ліниво

    public LocationProxy(String name, int minLevel) {
        this.name = name;
        this.minLevel = minLevel;
    }

    @Override public String getName() { return name; }

    @Override public boolean enter(Player player) {
        String src = "LocationProxy:" + name;
        // захисний проксі: перевірка рівня гравця
        if (player.level < minLevel) {
            Logger.log(src, "Відмова гравцю " + player.name + " (рівень " + player.level
                    + "): Локація доступна з " + minLevel + " рівня");
            return false;
        }
        // віртуальний проксі: ліниве створення справжньої локації лише при першому вході
        if (real == null) {
            Logger.log(src, "Перший вхід, локацію ще не завантажено → створюємо справжню локацію");
            real = new RealLocation(name);
        } else {
            Logger.log(src, "Локацію вже завантажено, повторного завантаження немає");
        }
        return real.enter(player);
    }
}
