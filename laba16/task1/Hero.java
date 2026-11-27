package task1;
import java.util.ArrayList;
import java.util.List;

// Originator. Його внутрішній стан закритий, але він сам вміє себе зберегти й відновити
public class Hero {
    private final String name;
    private int hp;
    private int strength;
    private String location;
    private final List<String> inventory = new ArrayList<>();
    private final List<String> quests = new ArrayList<>();
    public Hero(String name, int hp, int strength, String location, List<String> items, List<String> quests) {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.location = location;
        this.inventory.addAll(items);
        this.quests.addAll(quests);
    }
    public String getName() { return name; }
    // дії, що змінюють стан
    public void takeDamage(int damage) { hp = Math.max(0, hp - damage); }
    public void loseItem(String item) { inventory.remove(item); }
    public void moveTo(String location) { this.location = location; }
    public void addQuest(String quest) { quests.add(quest); }
    // Memento. Створює й повертає новий знімок поточного стану героя
    public Memento save() {
        return new Memento(hp, strength, location, inventory, quests);
    }
    public void restore(Memento m) {
        hp = m.hp;
        strength = m.strength;
        location = m.location;
        inventory.clear();
        inventory.addAll(m.inventory);
        quests.clear();
        quests.addAll(m.quests);
    }
    @Override public String toString() {
        return name + " [HP " + hp + ", сила " + strength + ", позиція «" + location
                + "», інвентар " + inventory + ", квести " + quests + "]";
    }
     //Memento: знімок стану. Поля й конструктор прочитати чи змінити
     //може лише Hero (зовнішній клас), інші класи вміст знімка не бачать
    public static class Memento {
        private final int hp;
        private final int strength;
        private final String location;
        private final List<String> inventory;
        private final List<String> quests;
        private Memento(int hp, int strength, String location, List<String> inventory, List<String> quests) {
            this.hp = hp;
            this.strength = strength;
            this.location = location;
            this.inventory = List.copyOf(inventory); // власна копія: подальші зміни героя знімок не торкаються
            this.quests = List.copyOf(quests);
        }
    }
}
