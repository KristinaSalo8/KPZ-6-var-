package task2;

//AbstractFactory - створює сімейство узгоджених предметів однієї фракції
public interface EquipmentFactory {
    String faction();
    Weapon createWeapon();
    Armor createArmor();
    Mount createMount();
}
