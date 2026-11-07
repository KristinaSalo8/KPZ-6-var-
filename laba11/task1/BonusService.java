package task1;
import common.Logger;
import java.util.HashSet;
import java.util.Set;

// Щоденний бонус
public class BonusService {
    private final Set<String> claimedToday = new HashSet<>();
    public void grantDaily(String player) {
        if (claimedToday.add(player)) {
            Logger.log("BonusService", "Нараховано щоденний бонус гравцю " + player + ": 100 золота");
        } else {
            Logger.log("BonusService", "Щоденний бонус гравцю " + player + " уже отримано сьогодні");
        }
    }
}
