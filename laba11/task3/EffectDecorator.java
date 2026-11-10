package task3;

import common.Logger;

/** Роль: Decorator. Абстрактний клас, який обгортає будь-якого GameCharacter, 
 * за замовчуванням передаэ всі методи йому все. */
public abstract class EffectDecorator implements GameCharacter {
    protected final GameCharacter wrapped;
    private final String effectName;

    protected EffectDecorator(GameCharacter wrapped, String effectName) {
        this.wrapped = wrapped;
        this.effectName = effectName;
    }

    /** Змінює характеристику і пише в журнал, що саме її змінила ця обгортка. */
    protected int change(String stat, int before, int delta) {
        int after = before + delta;
        Logger.log(effectName, stat + ": " + before + " → " + after + " (змінює обгортка)");
        return after;
    }

    @Override public String getDescription() { return wrapped.getDescription() + " + " + effectName; }
    @Override public int getAttack() { return wrapped.getAttack(); }
    @Override public int getDefense() { return wrapped.getDefense(); }
    @Override public int getSpeed() { return wrapped.getSpeed(); }
}
