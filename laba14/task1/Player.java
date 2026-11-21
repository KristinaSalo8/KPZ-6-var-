package task1;
import common.Logger;
import java.util.ArrayList;
import java.util.List;

// Subject: гравець. Не знає конкретних отримувачів - лише список спостерігачів
public class Player {
    private final String name;
    private int level = 1;
    private final List<PlayerObserver> observers = new ArrayList<>();
    public Player(String name) { this.name = name; }
    public String getName() { return name; }
    public void subscribe(PlayerObserver o) {
        observers.add(o);
        Logger.log(name, "Підписано: " + o.getName());
    }
    public void unsubscribe(PlayerObserver o) {
        observers.remove(o);
        Logger.log(name, "Відписано: " + o.getName());
    }
    public void killMonster(String monster) {
        notifyObservers(new GameEvent(EventType.MONSTER_KILLED, monster));
    }
    public void levelUp() {
        level++;
        notifyObservers(new GameEvent(EventType.LEVEL_UP, String.valueOf(level)));
    }
    public void completeQuest(String quest) {
        notifyObservers(new GameEvent(EventType.QUEST_COMPLETED, quest));
    }
    private void notifyObservers(GameEvent event) {
        Logger.log(name, "Подія [" + event + "] → сповіщаю підписників: " + observers.size());
        for (PlayerObserver o : new ArrayList<>(observers)) { // копія: підписка може змінитись під час розсилки
            o.onEvent(event);
        }
    }
}