package task1;
import common.Logger;

//Завантаження персонажа
public class CharacterService {
    public void load(String player) {
        Logger.log("CharacterService", "Завантажено персонажа гравця " + player + " (рівень 12)");
    }
}
