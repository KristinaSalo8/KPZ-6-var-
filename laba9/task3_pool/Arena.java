package task3_pool;

import common.Logger;
import java.util.ArrayList;
import java.util.List;

/** Принцип Reusable - об'єкт, який повторно використовується */
public class Arena {
    final String id;
    String match;
    int scoreA, scoreB, timer;
    List<String> players = new ArrayList<>();
    List<String> items = new ArrayList<>();
    int matchesPlayed = 0;

    /** Дорога підготовка: мапа, об'єкти, таймер. */
    public Arena(String id) {
        this.id = id;
        Logger.log("Arena", id + ": дорога підготовка (мапа, об'єкти, таймер)");
        Logger.sleep(300);
    }

    void start(String match) {
        this.match = match;
        this.players.addAll(List.of(match.split(" vs ")));
        this.items.add("аптечка");
        this.timer = 600;
        this.matchesPlayed++;
    }

    /** Скидання стану перед повторною видачею. */
    void reset() {
        match = null;
        scoreA = scoreB = timer = 0;
        players.clear();
        items.clear();
    }

    @Override public String toString() {
        return id + " (матч=" + match + ", рахунок " + scoreA + ":" + scoreB + ")";
    }
}
