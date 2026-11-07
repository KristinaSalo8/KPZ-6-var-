package task1;
import common.Logger;

//Завантаження інвентарю
public class InventoryService {
    public void load(String player) {
        Logger.log("InventoryService", "Завантажено інвентар гравця " + player + " (14 предметів)");
    }
}
