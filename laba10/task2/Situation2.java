package task2;

import common.Logger;
public class Situation2 {
    public static void run() {
        EquipmentService service = new EquipmentService(); // один код видачі для всіх фракцій
        service.issue("Cеба", new ElfFactory());
        service.issue("Олег", new DwarfFactory());
        service.issue("Іван", new HumanFactory());
        Logger.log("Game", "Додано нову фракцію «Орки»");
        service.issue("Бабайка", new OrcFactory());
    }
}