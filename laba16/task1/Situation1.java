package task1;
import common.Logger;
import java.util.List;

public class Situation1 {
    public static void run() {
        Hero hero = new Hero("Ярослав", 100, 15, "Чорний ліс",
                List.of("Меч", "Зілля лікування", "Лук", "Срібний кинджал"), List.of("Вовчі сліди"));
        SaveManager saves = new SaveManager();
        //Збереження перед боєм
        Logger.log(hero.getName(), "Стан перед боєм: " + hero);
        saves.save(1, hero);
        //Бій: втрачено здоров'я й предмети, збереження в слот 2
        Logger.log(hero.getName(), "Бій із вовкулаком!");
        hero.takeDamage(65);
        hero.loseItem("Зілля лікування");
        hero.loseItem("Лук");
        hero.moveTo("Печера вовкулаків");
        hero.addQuest("Знайти вовкулачу печеру");
        Logger.log(hero.getName(), "Стан після бою: " + hero);
        saves.save(2, hero);
        //Відновлення слота 1, потім слота 2
        System.out.println();
        saves.load(1, hero);
        Logger.log(hero.getName(), "Стан після відновлення слота 1: " + hero);
        saves.load(2, hero);
        Logger.log(hero.getName(), "Стан після відновлення слота 2: " + hero);
        saves.load(3, hero);
    }
}