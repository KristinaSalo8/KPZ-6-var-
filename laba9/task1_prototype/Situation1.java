package task1_prototype;
import common.Logger;
import java.util.ArrayList;
import java.util.List;
// Спавн монстрів через клонування
public class Situation1 {
    public static void run() {
        Monster reference = new Monster("Вовк", 5, new Weapon("Ікла", 10), List.of("Вкус"), List.of("Шкура", "Ікло"));
        List<Monster> pack = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            pack.add(reference.copy());
        }
        Logger.log("Spawn", "На локації «Чорний ліс» з'явилося 5 вовків (без повторного завантаження)");
        // Змінюємо одну копію - еталон і інші не повинні постраждати.
        Monster leader = pack.get(0);
        leader.setLevel(10);
        leader.getWeapon().setName("Кігті ватажка");
        leader.getWeapon().setDamage(25);
        leader.getSkills().add("Виття");
        Logger.log("Spawn", "Вовк №1 став ватажком");
        System.out.println("Еталон:           " + reference);
        System.out.println("Ватажок:          " + leader);
        System.out.println("Звичайний вовк:   " + pack.get(1));
    }
}
