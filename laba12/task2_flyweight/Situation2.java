package task2_flyweight;

import common.Logger;
import java.util.Random;

/** Ситуація 2: рослинність на мапі (Flyweight). */
public class Situation2 {
    public static void run() {
        String[] species = {"Дуб", "Сосна", "Береза", "Ліщина", "Верес", "Валун"};
        Landscape landscape = new Landscape();
        Random rnd = new Random(42);

        Logger.log("Landscape", "Розміщуємо 100 000 об'єктів рослинності 6 видів");
        for (int i = 0; i < 100_000; i++) {
            landscape.plant(species[rnd.nextInt(species.length)],
                    rnd.nextDouble() * 5000, rnd.nextDouble() * 5000,
                    0.8 + rnd.nextDouble() * 0.6, rnd.nextDouble() * 360);
        }

        Logger.log("Landscape", "Об'єктів рослинності: " + PlantInstance.getCreatedCount());
        Logger.log("Landscape", "Об'єктів видів: " + landscape.getFactory().getTypeCount());

        // Два дуби в різних місцях посилаються на один об'єкт виду
        PlantInstance first = null, second = null;
        for (PlantInstance p : landscape.getPlants()) {
            if (!p.getType().getName().equals("Дуб")) continue;
            if (first == null) first = p; else { second = p; break; }
        }
        Logger.log("Landscape", "Перший дуб:  " + first);
        Logger.log("Landscape", "Другий дуб:  " + second);
        Logger.log("Landscape", "Той самий об'єкт виду: " + (first.getType() == second.getType())
                + " (id виду: " + System.identityHashCode(first.getType()) + " і "
                + System.identityHashCode(second.getType()) + ")");

        long withFlyweight = 6L * landscape.getFactory().getTypeSizeBytes("Дуб");
        long without = 100_000L * landscape.getFactory().getTypeSizeBytes("Дуб");
        Logger.log("Landscape", "Ресурси видів: ~" + withFlyweight / 1024 + " КБ замість ~"
                + without / (1024 * 1024) + " МБ без спільного використання");
    }
}
