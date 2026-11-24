package task1;
import common.Logger;

// ConcreteState: атака
public class AttackState implements MonsterState {
    @Override public String getName() { return "Атака"; }
    @Override public void update(Monster m, int playerDistance) {
        if (m.isLowHealth()) {
            m.setState(new FleeState());
        } else if (playerDistance > 1) {
            m.setState(new ChaseState());
        } else {
            Logger.log(m.getName(), "[Атака] Кусає гравця (здоров'я " + m.getHp() + ")");
        }
    }
}
