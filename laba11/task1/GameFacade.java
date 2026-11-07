package task1;
import common.Logger;

//Facade: Уся послідовність входу описана в одному місці (enterWorld).
// Звичайний вхід і перепідключення використовують одну й ту саму операцію.
public class GameFacade {
    private final AuthService auth;
    private final CharacterService characters;
    private final InventoryService inventory;
    private final ServerSelector servers;
    private final ChatService chat;
    private final BonusService bonus;
    public GameFacade(AuthService auth, CharacterService characters, InventoryService inventory, ServerSelector servers, ChatService chat, BonusService bonus) {
        this.auth = auth;
        this.characters = characters;
        this.inventory = inventory;
        this.servers = servers;
        this.chat = chat;
        this.bonus = bonus;
    }
    public void enterWorld(String player) {
        Logger.log("GameFacade", "Вхід гравця " + player + " у світ (одна операція)");
        auth.authenticate(player);
        characters.load(player);
        inventory.load(player);
        servers.select(player);
        chat.connect(player);
        bonus.grantDaily(player);
        Logger.log("GameFacade", "Гравець " + player + " увійшов у світ");
    }
}
