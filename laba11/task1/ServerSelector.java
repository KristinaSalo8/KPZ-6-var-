package task1;
import common.Logger;

//Вибір сервера локації
public class ServerSelector {
    public String select(String player) {
        String server = "Північний форпост-1";
        Logger.log("ServerSelector", "Для гравця " + player + " обрано сервер локації «" + server + "»");
        return server;
    }
}
