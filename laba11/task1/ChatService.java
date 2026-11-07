package task1;
import common.Logger;

//Чат
public class ChatService {
    public void connect(String player) {
        Logger.log("ChatService", "Гравця " + player + " підключено до чату");
    }
}
