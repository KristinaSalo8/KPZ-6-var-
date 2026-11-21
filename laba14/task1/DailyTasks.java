package task1;
import common.Logger;

// ConcreteObserver: щоденні завдання (цікавлять лише вбивства)
public class DailyTasks implements PlayerObserver {
    private int kills;
    @Override public String getName() { return "Щоденні завдання"; }
    @Override public void onEvent(GameEvent e) {
        if (e.getType() != EventType.MONSTER_KILLED) return;
        kills++;
        if (kills >= 2) Logger.log(getName(), "Завдання «Вбити 2 монстрів» виконано");
        else Logger.log(getName(), "Завдання «Вбити 2 монстрів»: " + kills + "/2");
    }
}