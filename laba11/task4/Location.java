package task4_proxy;

/** Роль: Subject - спільний інтерфейс локації. Сервер працює лише з ним. */
public interface Location {
    String getName();
    boolean enter(Player player);
}
