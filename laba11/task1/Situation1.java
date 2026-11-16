package task1;
import common.Logger;

public class Situation1 {
    public static void run() {
        InventoryService inventory = new InventoryService();
        GameFacade facade = new GameFacade(new AuthService(), new CharacterService(), inventory, new ServerSelector(), new ChatService(), new BonusService());
        facade.enterWorld("Oleg");
        Logger.log("Network", "З'єднання гравця Oleg розірвано");
        facade.enterWorld("Oleg");
        Logger.log("Game", "Окреме перезавантаження інвентарю");
        inventory.load("Oleg");
    }
}
