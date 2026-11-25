package task3;

/** Предмет здобичі */
public class Item {
    private final String name;
    private final String forClass;

    public Item(String name, String forClass) {
        this.name = name;
        this.forClass = forClass;
    }

    public String getName() { return name; }

    public String getForClass() { return forClass; }
}
