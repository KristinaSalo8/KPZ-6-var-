package task1;
import common.Logger;

// ConcreteObserver: система досягнень(Пояснює роль класу як конкретного спостерігача)
public class AchievementSystem implements PlayerObserver {
    private int kills;
    @Override public String getName() { return "Система досягнень"; }
    @Override public void onEvent(GameEvent e) {
        switch (e.getType()) {
            case MONSTER_KILLED -> {
                kills++;
                if (kills == 1) Logger.log(getName(), "Розблоковано досягнення «Перша кров»");
                else Logger.log(getName(), "Вбито монстрів: " + kills);
            }
            case LEVEL_UP -> Logger.log(getName(), "Розблоковано досягнення «Рівень " + e.getDetail() + "»");
            case QUEST_COMPLETED -> Logger.log(getName(), "Розблоковано досягнення «Виконавець завдань»");
        }
    }
}