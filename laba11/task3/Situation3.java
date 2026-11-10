package task3;

import common.Logger;

/** Ситуація 3: ефекти на персонажі (Decorator). */
public class Situation3 {

    static void printStats(GameCharacter c) {
        int atk = c.getAttack(), def = c.getDefense(), spd = c.getSpeed();
        Logger.log("Персонаж", c.getDescription() + ": атака " + atk + ", захист " + def + ", швидкість " + spd);
    }

    public static void run() {
        GameCharacter hero = new BaseCharacter("Герой", 20, 10, 10);
        printStats(hero);

        Logger.log("Game", "Накладено зілля сили і благословення");
        hero = new Effects.Blessing(new Effects.StrengthPotion(hero));
        printStats(hero);

        Logger.log("Game", "Накладено отруту і прокляття повільності");
        hero = new Effects.SlownessCurse(new Effects.Poison(hero));
        printStats(hero);

        GameCharacter goblin = new BaseCharacter("Гоблін", 8, 5, 8);
        Combat.attack(hero, goblin);
    }
}
