package task3_builder;

/** Роль: Director. Типові персонажі формуються однаковою послідовністю кроків в одному місці. */
public class CharacterDirector {

    public Character buildWarrior(CharacterBuilder b, String nickname) {
        return b.nickname(nickname).race("Людина").characterClass("Воїн")
                .appearance("Кольчуга, шрам на щоці")
                .addSkill("Удар щитом").addSkill("Бойовий клич")
                .uiTheme("Темна").build();
    }

    public Character buildMage(CharacterBuilder b, String nickname) {
        return b.nickname(nickname).race("Ельф").characterClass("Маг")
                .appearance("Синя мантія, посох")
                .addSkill("Вогняна куля").addSkill("Телепорт")
                .uiTheme("Світла").build();
    }
}
