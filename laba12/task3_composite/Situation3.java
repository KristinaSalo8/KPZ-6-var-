package task3_composite;

import common.Logger;

/** Ситуація 3: гільдії і загони (Composite). */
public class Situation3 {
    public static void run() {
        // Загін у загоні - без жодних змін у коді розрахунку
        Group scouts = new Group("Загін", "Розвідники")
                .add(new Player("Loki", 25)).add(new Player("Nyx", 35));
        Group alpha = new Group("Загін", "Альфа")
                .add(new Player("Aldar", 40)).add(new Player("Torin", 55));
        Group beta = new Group("Загін", "Бета")
                .add(new Player("Mira", 30)).add(scouts);
        Group wolves = new Group("Гільдія", "Вовки").add(alpha).add(beta);

        Group gamma = new Group("Загін", "Гамма")
                .add(new Player("Odin", 60)).add(new Player("Frey", 45));
        Group ravens = new Group("Гільдія", "Круки").add(gamma).add(new Player("Hela", 50));

        Group alliance = new Group("Альянс", "Північний Союз").add(wolves).add(ravens);

        Logger.log("Game", "Структура альянсу:");
        alliance.print("");

        Logger.log("Game", "Нагорода для альянсу: 8000");
        alliance.distributeReward(8000);

        Logger.log("Game", "Нагорода лише для гільдії «Вовки»: 5000 (той самий виклик)");
        wolves.distributeReward(5000);
    }
}
