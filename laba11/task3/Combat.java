package task3;

import common.Logger;

/** Бойова система: працює з GameCharacter однаково для звичайного персонажа і персонажа з ефектами. */
public class Combat {
    public static int attack(GameCharacter attacker, GameCharacter defender) {
        int atk = attacker.getAttack();
        int def = defender.getDefense();
        int damage = Math.max(1, atk - def);
        Logger.log("Combat", attacker.getDescription() + " атакує " + defender.getDescription()
                + ": атака " + atk + " - захист " + def + " = шкода " + damage);
        return damage;
    }
}
