package task1;
import common.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Invoker: виконує дії, записує їх, скасовує (лише в тренуванні) і повторює бій.
public class BattleRecorder {
    private final boolean training;
    private final List<BattleCommand> history = new ArrayList<>();
    public BattleRecorder(boolean training) { this.training = training; }
    public void perform(BattleCommand command) {
        Logger.log("Сервер", "Отримано дію: " + command.describe());
        command.execute();
        history.add(command);
    }
    //Скасувати останню дію - тільки в режимі тренування
    public void undoLast() {
        if (!training) {
            Logger.log("Запис бою", "Скасування недоступне поза тренуванням");
            return;
        }
        if (history.isEmpty()) {
            Logger.log("Запис бою", "Немає дій для скасування");
            return;
        }
        BattleCommand last = history.remove(history.size() - 1);
        Logger.log("Запис бою", "Скасовую: " + last.describe());
        last.undo();
    }
    //Відтворити записані дії заново на нових персонажах
    public void replay(Map<Fighter, Fighter> fighters) {
        Logger.log("Запис бою", "Повтор бою: " + history.size() + " дій");
        for (BattleCommand c : history) {
            c.copyFor(fighters).execute();
        }
    }
    public int size() { return history.size(); }
}
