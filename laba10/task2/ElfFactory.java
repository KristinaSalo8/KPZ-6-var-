package task2;

//ConcreteFactory - спорядження фракції «Ельфи»
public class ElfFactory implements EquipmentFactory {
    @Override public String faction() { return "Ельфи"; }
    @Override public Weapon createWeapon() { return new Sword(); }
    @Override public Armor createArmor() { return new Mail(); }
    @Override public Mount createMount() { return new Beast(); }
    private static class Sword extends BaseItem implements Weapon {
        Sword() { super("Лук Лісового Співу", "Ельфи"); }
    }
    private static class Mail extends BaseItem implements Armor {
        Mail() { super("Листяна кольчуга", "Ельфи"); }
    }
    private static class Beast extends BaseItem implements Mount {
        Beast() { super("Олень", "Ельфи"); }
    }
}