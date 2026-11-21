package task1;
import common.Logger;

// ConcreteObserver: сезонна подія - діє обмежений час і сама відписується від гравця
public class SeasonalEvent implements PlayerObserver {
    private final Player player;
    private int points;
    public SeasonalEvent(Player player) { this.player = player; }
    @Override public String getName() { return "Сезонна подія «Зимове свято»"; }
    @Override public void onEvent(GameEvent e) {
        points += 10;
        Logger.log(getName(), "+10 очок за подію [" + e + "], разом " + points);
    }
    // Завершення події: відписуємось під час виконання програми
    public void end() {
        Logger.log(getName(), "Подію завершено, відписуюсь від гравця " + player.getName());
        player.unsubscribe(this);
    }
}
