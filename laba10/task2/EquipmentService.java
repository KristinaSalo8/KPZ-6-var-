package task2;
import common.Logger;

// Клієнт: код видачі. Працює лише з абстракціями (EquipmentFactory, Weapon, Armor, Mount)
public class EquipmentService {

    public EquipmentSet issue(String character, EquipmentFactory factory) {
        EquipmentSet set = new EquipmentSet(factory.createWeapon(), factory.createArmor(), factory.createMount());
        Logger.log("Видача", "Персонаж " + character + " (" + factory.faction() + "): " + set);
        Logger.log("Видача", "Усі предмети набору належать до однієї фракції («" + factory.faction()+ "»): " + (set.isSingleFaction(factory.faction()) ? "так" : "НІ"));
        return set;
    }
}