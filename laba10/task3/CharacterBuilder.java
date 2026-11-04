package task3_builder;

import java.util.ArrayList;
import java.util.List;

/** Роль: Builder. Кожен крок - окрема дія, повна перевірка - у build(). */
public class CharacterBuilder {
    String nickname, race, characterClass, appearance, biography, uiTheme;
    final List<String> skills = new ArrayList<>();

    public CharacterBuilder nickname(String v) { this.nickname = v; return this; }

    public CharacterBuilder race(String v) { this.race = v; return this; }

    public CharacterBuilder characterClass(String v) { this.characterClass = v; return this; }

    public CharacterBuilder appearance(String v) { this.appearance = v; return this; }

    public CharacterBuilder addSkill(String v) { this.skills.add(v); return this; }

    public CharacterBuilder biography(String v) { this.biography = v; return this; }

    public CharacterBuilder uiTheme(String v) { this.uiTheme = v; return this; }

    /** Завершальний крок: перевірка обов'язкових параметрів. */
    public Character build() {
        if (nickname == null || nickname.isBlank())
            throw new IllegalStateException("Неможливо створити персонажа: не вказано нікнейм.");
        if (race == null || race.isBlank())
            throw new IllegalStateException("Неможливо створити персонажа: не обрано расу.");
        if (characterClass == null || characterClass.isBlank())
            throw new IllegalStateException("Неможливо створити персонажа: не обрано клас.");
        return new Character(this);
    }
}
