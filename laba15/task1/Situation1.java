package task1;
import common.Logger;

public class Situation1 {
    private static void playerAt(Monster wolf, int distance) {
        Logger.log("Гравець", "Відстань до вовка: " + distance);
        wolf.update(distance);
    }
    public static void run() {
        Monster wolf = new Monster("Вовк", 100, new PatrolState());
        // Гравець наближається: патрулювання → переслідування → атака
        playerAt(wolf, 12);
        playerAt(wolf, 5);
        playerAt(wolf, 3);
        playerAt(wolf, 1);
        playerAt(wolf, 1);
        // Здоров'я падає нижче 20% → втеча
        System.out.println();
        wolf.takeDamage(85);
        playerAt(wolf, 1);
        playerAt(wolf, 3);
        // Гравець відходить далеко → повернення на спавн
        System.out.println();
        playerAt(wolf, 12);
        playerAt(wolf, 15);
        playerAt(wolf, 15);
        playerAt(wolf, 15);
    }
}