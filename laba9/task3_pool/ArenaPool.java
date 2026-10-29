package task3_pool;

import common.Logger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Патерн ObjectPool - збережений пул об'єктів, які повторно використовуються.
 * Стратегія черги: FIFO (хто раніше прийшов, той раніше грає). */
public class ArenaPool {
    private final Queue<Arena> free = new LinkedList<>();
    private final Queue<String> waiting = new LinkedList<>();
    private final List<Arena> all = new ArrayList<>();

    public ArenaPool(int size) {
        for (int i = 1; i <= size; i++) {
            Arena a = new Arena("A-" + i);
            all.add(a);
            free.add(a);
        }
    }

    /** Видати арену або поставити матч у чергу. Повертає арену чи null. */
    public Arena acquire(String match) {
        Arena a = free.poll();
        if (a == null) {
            waiting.add(match);
            Logger.log("ArenaPool", "Вільних арен немає, матч '" + match + "' у черзі (позиція " + waiting.size() + ")");
            return null;
        }
        a.start(match);
        Logger.log("ArenaPool", "Арена " + a.id + " → матч " + match);
        return a;
    }

    /** Повернути арену: скинути стан і одразу віддати наступному в черзі. */
    public void release(Arena a) {
        a.reset();
        Logger.log("ArenaPool", a.id + " повернено, стан скинуто");
        free.add(a);
        String next = waiting.poll();
        if (next != null) acquire(next);
    }

    public void printStats() {
        Logger.log("ArenaPool", "Статистика:");
        for (Arena a : all) System.out.println("    " + a.id + ": матчів " + a.matchesPlayed);
        System.out.println("    Загальна кількість створених арен: " + all.size());
    }
}
