package task2;

import common.Logger;

/** Канал чату: сам збирає ланцюг фільтрів у заданому порядку (під час виконання). */
public class ChatChannel {
    private final String name;
    private final ChatFilter first;

    public ChatChannel(String name, ChatFilter... filters) {
        this.name = name;
        for (int i = 0; i + 1 < filters.length; i++) {
            filters[i].setNext(filters[i + 1]);
        }
        this.first = filters.length > 0 ? filters[0] : null;
    }

    public void send(Player sender, String text) { // надсилає повідомлення через ланцюг фільтрів
        Message m = new Message(sender, text);
        Logger.log("Канал «" + name + "»", sender.getName() + " надсилає: «" + text + "»");
        boolean ok = first == null || first.handle(m);
        if (ok) {
            Logger.log("Канал «" + name + "»", "ДОСТАВЛЕНО: " + sender.getName() + ": " + m.getText());
        } else {
            Logger.log("Канал «" + name + "»", "НЕ доставлено повідомлення від " + sender.getName());
        }
    }
}
