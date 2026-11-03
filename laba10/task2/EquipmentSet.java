package task2;

// Набір стартового спорядження персонажа
public class EquipmentSet {
    final Weapon weapon;
    final Armor armor;
    final Mount mount;
    EquipmentSet(Weapon weapon, Armor armor, Mount mount) {
        this.weapon = weapon;
        this.armor = armor;
        this.mount = mount;
    }
    // Усі предмети належать до однієї фракції(перевірка)
    boolean isSingleFaction(String faction) {
        return weapon.faction().equals(faction) && armor.faction().equals(faction)
                && mount.faction().equals(faction);
    }

    @Override public String toString() {
        return "зброя: " + weapon.name() + ", броня: " + armor.name() + ", тварина: " + mount.name();
    }
}