package task1;
import common.Logger;

public class Situation1 {
    public static void run() {
        InventoryService inventory = new InventoryService();
        GameFacade facade = new GameFacade(new AuthService(), new CharacterService(), inventory, new ServerSelector(), new ChatService(), new BonusService());
        facade.enterWorld("Aldar");
        Logger.log("Network", "З'єднання гравця Aldar розірвано");
        facade.enterWorld("Aldar");
        Logger.log("Game", "Окреме перезавантаження інвентарю");
        inventory.load("Aldar");
    }
}
