package task2;

//ConcreteFactory - спорядження фракції «Гноми»
public class DwarfFactory implements EquipmentFactory {
    @Override public String faction() { return "Гноми"; }
    @Override public Weapon createWeapon() { return new Sword(); }
    @Override public Armor createArmor() { return new Mail(); }
    @Override public Mount createMount() { return new Beast(); }
    private static class Sword extends BaseItem implements Weapon {
        Sword() { super("Бойова сокира", "Гноми"); }
    }
    private static class Mail extends BaseItem implements Armor {
        Mail() { super("Гномська плитова броня", "Гноми"); }
    }
    private static class Beast extends BaseItem implements Mount {
        Beast() { super("Гірський баран", "Гноми"); }
    }
}