package task1;
import common.Logger;

// ConcreteObserver: система квестів
public class QuestSystem implements PlayerObserver {
    private int progress;
    @Override public String getName() { return "Система квестів"; }
    @Override public void onEvent(GameEvent e) {
        switch (e.getType()) {
            case MONSTER_KILLED -> {
                progress++;
                Logger.log(getName(), "Квест «Мисливець на звірів»: прогрес " + progress + "/3");
            }
            case LEVEL_UP -> Logger.log(getName(), "Відкрито нові квести для рівня " + e.getDetail());
            case QUEST_COMPLETED -> Logger.log(getName(), "Нагороду за квест «" + e.getDetail() + "» видано");
        }
    }
}