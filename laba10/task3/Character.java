package task3;

import java.util.List;

/** Роль: Product. Незмінний (immutable) персонаж, створюється лише через Builder. */
public class Character {
    private final String nickname;   // обов'язкові
    private final String race;
    private final String characterClass;
    private final String appearance; // необов'язкові
    private final List<String> skills;
    private final String biography;
    private final String uiTheme;

    Character(CharacterBuilder b) {
        this.nickname = b.nickname;
        this.race = b.race;
        this.characterClass = b.characterClass;
        this.appearance = b.appearance;
        this.skills = List.copyOf(b.skills);
        this.biography = b.biography;
        this.uiTheme = b.uiTheme;
    }

    @Override public String toString() {
        return "Персонаж {\n"
                + "  нікнейм:    " + nickname + "\n"
                + "  раса:       " + race + "\n"
                + "  клас:       " + characterClass + "\n"
                + "  зовнішність: " + orDash(appearance) + "\n"
                + "  навички:    " + (skills.isEmpty() ? "-" : skills) + "\n"
                + "  біографія:  " + orDash(biography) + "\n"
                + "  тема UI:    " + orDash(uiTheme) + "\n}";
    }

    private static String orDash(String s) { return s == null ? "-" : s; }
}
