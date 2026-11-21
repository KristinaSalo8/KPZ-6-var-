package task1;

public class Situation1 {
    public static void run() {
        Player hero = new Player("Ярослав");
        //Підписуємо досягнення, статистику, квести й щоденні завдання
        hero.subscribe(new AchievementSystem());
        hero.subscribe(new PlayerStatistics());
        hero.subscribe(new QuestSystem());
        hero.subscribe(new DailyTasks());
        hero.killMonster("Вовк");
        //Підписуємо сезонну подію
        System.out.println();
        SeasonalEvent winter = new SeasonalEvent(hero);
        hero.subscribe(winter);
        hero.killMonster("Ведмідь");
        //Сезонна подія завершилась і відписалась - рівень вона вже не бачить
        System.out.println();
        winter.end();
        hero.levelUp();
    }
}