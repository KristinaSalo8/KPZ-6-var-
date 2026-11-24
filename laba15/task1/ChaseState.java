package task1;
import common.Logger;

// ConcreteState: переслідування гравця
public class ChaseState implements MonsterState {
    @Override public String getName() { return "Переслідування"; }
    @Override public void update(Monster m, int playerDistance) {
        if (m.isLowHealth()) {
        } else if (playerDistance <= 1) {
        } else if (playerDistance > 10) {
            Logger.log(m.getName(), "[Переслідування] Гравець надто далеко (" + playerDistance + ")");
        } else {
            m.moveFromSpawn(2);
            Logger.log(m.getName(), "[Переслідування] Біжить за гравцем, відстань " + playerDistance + ", від спавну " + m.getDistanceFromSpawn());
        }
    }
}