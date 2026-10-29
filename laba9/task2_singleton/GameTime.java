package task2_singleton;

import common.Logger;

/** Патерн Singleton - у класу буде лише один єдиний екземпляр, і надає до нього глобальну точку доступу */
public class GameTime { //ігровий час світу
    private static GameTime instance;
    private int hour = 12;

    private GameTime() { // приватний конструктор - створити в обхід неможливо
        Logger.log("GameTime", "Ігровий час світу ініціалізовано");
    }

    public static synchronized GameTime getInstance() { // синхронізований метод - т. доступу
        if (instance == null) instance = new GameTime();
        return instance;
    }

    public void setHour(int hour) { this.hour = hour; }

    public int getHour() { return hour; }

    public boolean isNight() { return hour >= 20 || hour < 6; }

    public String getId() { return "GT-" + Integer.toHexString(System.identityHashCode(this)); }
}
