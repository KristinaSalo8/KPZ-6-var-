package task1;
import common.Logger;
import java.util.List;

public class Situation1 {
    public static void run() {
        List<String> enemies = List.of("Гоблін", "Орк", "Тролль");
        new SingleTargetStrike(new Fire()).use("Маг", List.of("Гоблін"));
        new AreaStrike(new Ice()).use("Маг", enemies);
        new ProtectiveBarrier(new Lightning()).use("Жрець", List.of("Розбійник"));
        Logger.log("Game", "Додано нову стихію «Отрута» (один клас)");
        new AreaStrike(new Poison()).use("Маг", enemies);
    }
}
