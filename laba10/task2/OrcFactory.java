package task2;

public class OrcFactory implements EquipmentFactory {
    @Override public String faction() { return "Орки"; }
    @Override public Weapon createWeapon() { return new Sword(); }
    @Override public Armor createArmor() { return new Mail(); }
    @Override public Mount createMount() { return new Beast(); }
    private static class Sword extends BaseItem implements Weapon {
        Sword() { super("Зазублений тесак", "Орки"); }
    }
    private static class Mail extends BaseItem implements Armor {
        Mail() { super("Броня з кісток", "Орки"); }
    }
    private static class Beast extends BaseItem implements Mount {
        Beast() { super("Вовк-варг", "Орки"); }
    }
}