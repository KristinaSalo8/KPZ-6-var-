package task1;

// Можливі дій гравця
public enum EventType {
    MONSTER_KILLED("вбивство монстра"),
    LEVEL_UP("отримання рівня"),
    QUEST_COMPLETED("завершення квесту");
    private final String label;
    EventType(String label) { this.label = label; }
    public String getLabel() { return label; }
}