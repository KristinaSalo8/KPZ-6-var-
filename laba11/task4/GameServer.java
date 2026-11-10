package task4_proxy;

import common.Logger;
import java.util.LinkedHashMap;
import java.util.Map;

/** Клієнт: сервер працює з локаціями через інтерфейс Location і не знає, чи їх завантажено. */
public class GameServer {
    private final Map<String, Location> locations = new LinkedHashMap<>();

    public void register(Location location) { locations.put(location.getName(), location); }

    public void start() {
        Logger.log("GameServer", "Сервер стартував із " + locations.size() + " локаціями: " + locations.keySet());
    }

    public void enter(Player player, String locationName) {
        Logger.log("GameServer", "Гравець " + player.name + " (рівень " + player.level + ") входить у «"
                + locationName + "»");
        locations.get(locationName).enter(player);
    }
}
