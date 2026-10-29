package task3_pool;

import common.Logger;
import java.util.ArrayList;
import java.util.List;

public class Situation3 {
    public static void run() {
        ArenaPool pool = new ArenaPool(5);

        String[] matches = {"Вовки vs Ворони", "Гусі vs Орли", "Тигри vs Яструби",
                "Ведмеді vs Лиси", "Круки vs Сови"};
        List<Arena> given = new ArrayList<>();
        for (String m : matches) {
            given.add(pool.acquire(m)); // 4-й і 5-й отримають null і стануть у чергу
        }

        // Перший матч завершується з рахунком 3:2
        Arena first = given.get(0);
        first.scoreA = 3;
        first.scoreB = 2;
        Logger.log("Match", "Матч '" + first.match + "' завершено з рахунком 3:2");
        pool.release(first);

        // Перевірка скидання: арена A-1 тепер у наступного матчу з рахунком 0:0
        Logger.log("Match", "Стан арени після повторної видачі: " + first);

        // Завершуємо решту, щоб черга повністю обслужилася
        pool.release(given.get(1));
        pool.release(first);
        pool.release(given.get(2));

        pool.printStats();
    }
}
