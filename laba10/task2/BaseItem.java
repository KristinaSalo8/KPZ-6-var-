package task2;

// Допоміжний базовий клас конкретних предметів
abstract class BaseItem implements Item {
    private final String name;
    private final String faction;
    BaseItem(String name, String faction) {
        this.name = name;
        this.faction = faction;
    }
    @Override public String name() { return name; }
    @Override public String faction() { return faction; }
}