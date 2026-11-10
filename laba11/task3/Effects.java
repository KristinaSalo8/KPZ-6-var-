package task3;

/** Роль: ConcreteDecorator - ефекти. Новий ефект = новий клас, існуючі не змінюються. */
public final class Effects {
    private Effects() { }

    public static class StrengthPotion extends EffectDecorator {
        public StrengthPotion(GameCharacter c) { super(c, "Зілля сили"); }
        @Override public int getAttack() { return change("атака", wrapped.getAttack(), +10); }
    }

    public static class Blessing extends EffectDecorator {
        public Blessing(GameCharacter c) { super(c, "Благословення"); }
        @Override public int getAttack() { return change("атака", wrapped.getAttack(), +5); }
        @Override public int getDefense() { return change("захист", wrapped.getDefense(), +5); }
    }

    public static class Poison extends EffectDecorator {
        public Poison(GameCharacter c) { super(c, "Отрута"); }
        @Override public int getAttack() { return change("атака", wrapped.getAttack(), -4); }
    }

    public static class SlownessCurse extends EffectDecorator {
        public SlownessCurse(GameCharacter c) { super(c, "Прокляття повільності"); }
        @Override public int getSpeed() { return change("швидкість", wrapped.getSpeed(), -6); }
    }

    public static class Shield extends EffectDecorator {
        public Shield(GameCharacter c) { super(c, "Щит"); }
        @Override public int getDefense() { return change("захист", wrapped.getDefense(), +15); }
    }
}
