package task2;

/** Запит, який рухається ланцюгом (текст фільтри можуть змінювати). */
public class Message {
    private final Player sender;
    private String text;

    public Message(Player sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    public Player getSender() { return sender; }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }
}
