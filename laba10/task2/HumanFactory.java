package task2;

public class HumanFactory implements EquipmentFactory {
    @Override public String faction() { return "Люди"; }
    @Override public Weapon createWeapon() { return new Sword(); }
    @Override public Armor createArmor() { return new Mail(); }
    @Override public Mount createMount() { return new Beast(); }
    private static class Sword extends BaseItem implements Weapon {
        Sword() { super("Лицарський меч", "Люди"); }
    }
    private static class Mail extends BaseItem implements Armor {
        Mail() { super("Сталевий обладунок", "Люди"); }
    }
    private static class Beast extends BaseItem implements Mount {
        Beast() { super("Кінь", "Люди"); }
    }
}
