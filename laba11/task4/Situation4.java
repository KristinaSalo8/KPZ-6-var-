package task4_proxy;

/** Ситуація 4: завантаження локацій (Proxy). */
public class Situation4 {
    public static void run() {
        GameServer server = new GameServer();
        server.register(new LocationProxy("Чорний ліс", 5));
        server.register(new LocationProxy("Північний форпост", 1));
        server.register(new LocationProxy("Туманні болота", 10));
        server.register(new LocationProxy("Гірський перевал", 15));
        server.register(new LocationProxy("Крижані печери", 20));
        server.start(); // жодного завантаження мап

        server.enter(new Player("Aldar", 10), "Чорний ліс");   // завантаження один раз
        server.enter(new Player("Torin", 12), "Чорний ліс");   // без завантаження
        server.enter(new Player("Novice", 3), "Крижані печери"); // відмова за рівнем
    }
}
