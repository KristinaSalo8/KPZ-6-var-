package task1;
import common.Logger;

// ConcreteState: повернення на місце спавну
public class ReturnState implements MonsterState {
    @Override public String getName() { return "Повернення на спавн"; }
    @Override public void update(Monster m, int playerDistance) {
        m.moveFromSpawn(-3);
        Logger.log(m.getName(), "[Повернення на спавн] До місця спавну лишилось " + m.getDistanceFromSpawn());
        if (m.getDistanceFromSpawn() == 0) {
            m.setState(new PatrolState());
        }
    }
}
