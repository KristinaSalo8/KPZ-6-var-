package task1;
import common.Logger;
import java.util.Map;
import java.util.TreeMap;

// Caretaker: керує слотами збережень, але не може змінити (і навіть прочитати) їхній вміст
public class SaveManager {
    private final Map<Integer, Hero.Memento> slots = new TreeMap<>();
    public void save(int slot, Hero hero) {
        slots.put(slot, hero.save());
        Logger.log("Менеджер збережень", "Слот " + slot + ": збережено стан персонажа " + hero.getName());
    }
    public void load(int slot, Hero hero) {
        Hero.Memento m = slots.get(slot);
        if (m == null) {
            Logger.log("Менеджер збережень", "Слот " + slot + " порожній");
            return;
        }
        hero.restore(m);
        Logger.log("Менеджер збережень", "Слот " + slot + ": відновлено стан персонажа " + hero.getName());
    }
}
