package task1;
import common.Logger;

// ConcreteObserver: статистика гравця
public class PlayerStatistics implements PlayerObserver {
    private int kills, levels, quests;
    @Override public String getName() { return "Статистика гравця"; }
    @Override public void onEvent(GameEvent e) {
        switch (e.getType()) {
            case MONSTER_KILLED -> kills++;
            case LEVEL_UP -> levels++;
            case QUEST_COMPLETED -> quests++;
        }
        Logger.log(getName(), "Оновлено: вбивств " + kills + ", рівнів " + levels + ", квестів " + quests);
    }
}