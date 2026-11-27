package task2;
import common.Logger;
import java.util.List;

// AbstractClass: Загальна послідовність етапів проходження підземелля
public abstract class Dungeon {
    // Template Method: порядок етапів зафіксований (final) і не змінюється в нащадках
    public final boolean run(String hero, int heroLevel) {
        Logger.log(getName(), hero + " (рівень " + heroLevel + ") проходить підземелля");
        if (!enter(hero, heroLevel)) return false;
        List<String> rooms = generateRooms();
        placeTraps();
        clearRooms(rooms);
        fightBoss(hero);
        giveReward(hero, rooms.size());
        return true;
    }
    //кроки, що відрізняються
    protected abstract String getName();
    protected abstract int getRequiredLevel();
    protected abstract List<String> generateRooms();
    protected abstract String getBoss();
    //кроки, які не обов'язкові
    protected void placeTraps() {
        Logger.log(getName(), "Етап «Пастки»: стандартні пастки");
    }
    //кроки, які спільні
    private boolean enter(String hero, int level) {
        if (level < getRequiredLevel()) {
            Logger.log(getName(), "Етап «Вхід»: " + hero + " - перевірку рівня не пройдено, вхід заборонено (потрібен " + getRequiredLevel() + ")");
            return false;
        }
        Logger.log(getName(), "Етап «Вхід»: перевірку рівня пройдено (потрібен " + getRequiredLevel() + ")");
        return true;
    }
    private void clearRooms(List<String> rooms) {
        for (String room : rooms) {
            Logger.log(getName(), "Етап «Проходження кімнат»: кімнату «" + room + "» пройдено");
        }
    }
    private void fightBoss(String hero) {
        Logger.log(getName(), "Етап «Бій з босом»: " + hero + " перемагає боса «" + getBoss() + "»");
    }
    private void giveReward(String hero, int roomCount) {
        int gold = 100 + 20 * roomCount;
        Logger.log(getName(), "Етап «Нагорода»: " + hero + " отримує " + gold + " золота");
    }
}