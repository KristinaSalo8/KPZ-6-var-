package task2_singleton;

import common.Logger;

public class Situation2 {
    public static void run() {
        GameTime weather = GameTime.getInstance();
        weather.setHour(22);
        Logger.log("Погода", "Світ переведено на 22:00, id часу = " + weather.getId());

        GameTime spawn = GameTime.getInstance();
        Logger.log("Спавн", "Час " + spawn.getHour() + ":00, id часу = " + spawn.getId());
        if (spawn.isNight()) Logger.log("Спавн", "Спавн нічних монстрів");
        else Logger.log("Спавн", "Спавн денних монстрів");

        GameTime trade = GameTime.getInstance();
        Logger.log("Торгівля", "id часу = " + trade.getId() + ", ніч: " + trade.isNight());

        GameTime quests = GameTime.getInstance();
        Logger.log("Квести", "id часу = " + quests.getId() + ", ніч: " + quests.isNight());
    }
}
