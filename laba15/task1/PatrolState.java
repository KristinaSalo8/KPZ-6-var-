package task1;
import common.Logger;

// ConcreteState: патрулювання
public class PatrolState implements MonsterState {
    @Override public String getName() { return "Патрулювання"; }
    @Override public void update(Monster m, int playerDistance) {
        if (playerDistance <= 5) {
            Logger.log(m.getName(), "[Патрулювання] Помітив гравця на відстані " + playerDistance);
        } else {
            Logger.log(m.getName(), "[Патрулювання] Обходить територію, гравець далеко (" + playerDistance + ")");
        }
    }
}
