package task2;
import common.Logger;

// Підключення сторонньої платіжної системи (Adapter)
public class Situation2 {
    public static void run() {
        GameStore store = new GameStore(new ThirdPartyPlatformAdapter());
        store.buyCurrency("Aldar", 500);
        Logger.log("Game", "Підключено другу платформу (EtaPay), код магазину не змінювався");
        GameStore store2 = new GameStore(new EtaPayAdapter());
        store2.buyCurrency("Aldar", 500);
    }
}
