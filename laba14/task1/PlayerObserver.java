package task1;

// Observer: система, яка реагує на дії гравця
public interface PlayerObserver {
    String getName();
    void onEvent(GameEvent event);
}