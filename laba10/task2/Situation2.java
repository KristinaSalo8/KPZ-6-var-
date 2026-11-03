package task2;

import common.Logger;
public class Situation2 {
    public static void run() {
        EquipmentService service = new EquipmentService(); // один код видачі для всіх фракцій
        service.issue("Леголас", new ElfFactory());
        service.issue("Гімлі", new DwarfFactory());
        service.issue("Арагорн", new HumanFactory());
        Logger.log("Game", "Додано нову фракцію «Орки»");
        service.issue("Грім", new OrcFactory());
    }
}