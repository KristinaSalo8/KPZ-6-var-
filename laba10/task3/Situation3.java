package task3_builder;

import common.Logger;

/** Створення персонажа */
public class Situation3 {
    public static void run() {
        // З усіма параметрами вручну
        Character full = new CharacterBuilder()
                .nickname("Торін").race("Гном").characterClass("Паладин")
                .appearance("Руда борода, золоті обладунки")
                .addSkill("Священний удар").addSkill("Зцілення")
                .biography("Вигнаний принц гірського королівства")
                .uiTheme("Темна")
                .build();
        Logger.log("Builder", "Створено персонажа з усіма параметрами:");
        System.out.println(full);

        // Типовий для швидкого старту
        Character mage = new CharacterDirector().buildMage(new CharacterBuilder(), "Мерлін");
        Logger.log("Director", "Створено типового персонажа «Маг»:");
        System.out.println(mage);

        // Без класу
        try {
            new CharacterBuilder().nickname("Іпз-шнік").race("Людина").build();
        } catch (IllegalStateException e) {
            Logger.log("Builder", e.getMessage());
        }
    }
}
