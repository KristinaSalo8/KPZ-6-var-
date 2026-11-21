package task1;

// Подія, яку видавець розсилає спостерігачам
public class GameEvent {
    private final EventType type;
    private final String detail;
    public GameEvent(EventType type, String detail) {
        this.type = type;
        this.detail = detail;
    }
    public EventType getType() { return type; }
    public String getDetail() { return detail; }
    @Override public String toString() { return type.getLabel() + ": " + detail; }
}