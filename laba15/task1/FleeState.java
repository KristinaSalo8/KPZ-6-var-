package task1;
import common.Logger;

// ConcreteState: втеча при низькому здоров'ї
public class FleeState implements MonsterState {
    @Override public String getName() { return "Втеча"; }
    @Override public void update(Monster m, int playerDistance) {
        if (playerDistance > 10) {
            Logger.log(m.getName(), "[Втеча] Втік достатньо далеко (" + playerDistance + ")");
        } else {
            m.moveFromSpawn(2);
            Logger.log(m.getName(), "[Втеча] Тікає від гравця, здоров'я " + m.getHp() + ", від спавну " + m.getDistanceFromSpawn());
        }
    }
}
