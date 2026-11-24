package task1;
import common.Logger;

// ConcreteState: переслідування гравця
public class ChaseState implements MonsterState {
    @Override public String getName() { return "Переслідування"; }
    @Override public void update(Monster m, int playerDistance) {
        if (m.isLowHealth()) {
            m.setState(new FleeState());
        } else if (playerDistance <= 1) {
            m.setState(new AttackState());
        } else if (playerDistance > 10) {
            Logger.log(m.getName(), "[Переслідування] Гравець надто далеко (" + playerDistance + ")");
        } else {
            m.moveFromSpawn(2);
            Logger.log(m.getName(), "[Переслідування] Біжить за гравцем, відстань " + playerDistance + ", від спавну " + m.getDistanceFromSpawn());
        }
    }
}