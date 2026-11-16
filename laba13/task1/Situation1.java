package task1;
import common.Logger;
import java.util.Map;

public class Situation1 {
    //Короткий бій з 5 дій
    private static void fight(BattleRecorder rec, Fighter hero, Fighter enemy) {
        rec.perform(new MoveCommand(hero, 3));
        rec.perform(new AttackCommand(hero, enemy, 15));
        rec.perform(new AttackCommand(enemy, hero, 20));
        rec.perform(new PotionCommand(hero, 30));
        rec.perform(new SkillCommand(hero, enemy, "Вогняна стріла", 25));
    }
    private static void state(String title, Fighter hero, Fighter enemy) {
        System.out.println("  " + title + ":");
        System.out.println("    " + hero);
        System.out.println("    " + enemy);
    }
    public static void run() {
        // 1. Бій з записом
        BattleRecorder rec = new BattleRecorder(false);
        Fighter hero = new Fighter("Ярослав", 100, 2);
        Fighter enemy = new Fighter("Вовкулака", 80, 0);
        fight(rec, hero, enemy);
        state("Стан після бою", hero, enemy);
        rec.undoLast(); // у бою скасування заборонене
        // 2. Повтор на нових персонажах
        Logger.log("Сервер", "Відтворення бою на нових персонажах");
        Fighter hero2 = new Fighter("Ярослав", 100, 2);
        Fighter enemy2 = new Fighter("Вовкулака", 80, 0);
        rec.replay(Map.of(hero, hero2, enemy, enemy2));
        state("Стан після повтору", hero2, enemy2);
        // 3. Тренування: скасування двох останніх дій
        BattleRecorder training = new BattleRecorder(true);
        Fighter hero3 = new Fighter("Ярослав", 100, 2);
        Fighter enemy3 = new Fighter("Вовкулака", 80, 0);
        fight(training, hero3, enemy3);
        state("Тренування: до скасування", hero3, enemy3);
        training.undoLast();
        training.undoLast();
        state("Тренування: після скасування двох дій", hero3, enemy3);
    }
}
