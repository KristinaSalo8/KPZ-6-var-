package task2;

import common.Logger;

/** Handler: або блокує повідомлення з причиною, або передає далі. */
public abstract class ChatFilter {
    private final String name;
    private ChatFilter next;

    protected ChatFilter(String name) { this.name = name; }

    public ChatFilter setNext(ChatFilter next) {
        this.next = next;
        return next;
    }

    /** true - повідомлення пройшло весь ланцюг, false - заблоковано. */
    public final boolean handle(Message m) {
        String reason = check(m);
        if (reason != null) {
            Logger.log(name, "БЛОКУЮ повідомлення від " + m.getSender().getName() + ": " + reason);
            return false;
        }
        Logger.log(name, "Перевірено повідомлення від " + m.getSender().getName() + " - передаю далі");
        return next == null || next.handle(m);
    }

    /** Повертає причину блокування або null, якщо повідомлення можна передати далі. */
    protected abstract String check(Message m);

    protected String getName() { return name; }
}
