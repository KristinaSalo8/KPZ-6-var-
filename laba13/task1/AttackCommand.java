package task1;
import common.Logger;
import java.util.Map;

//ConcreteCommand: звичайна атака
public class AttackCommand implements BattleCommand {
    private final Fighter actor;
    private final Fighter target;
    private final int damage;
    private int dealt; // скільки HP знято (потрібно для скасування)
    public AttackCommand(Fighter actor, Fighter target, int damage) {
        this.actor = actor;
        this.target = target;
        this.damage = damage;
    }
    @Override public void execute() {
        dealt = target.takeDamage(damage);
        Logger.log(actor.getName(), "Атака → " + target.getName() + ": -" + dealt + " HP (залишилось " + target.getHp() + ")");
    }
    @Override public void undo() {
        target.heal(dealt);
        Logger.log(actor.getName(), "Скасування атаки: " + target.getName() + " знову має " + target.getHp() + " HP");
    }
    @Override public String describe() { return actor.getName() + ": атака " + target.getName() + " (" + damage + ")"; }
    @Override public BattleCommand copyFor(Map<Fighter, Fighter> f) {
        return new AttackCommand(f.get(actor), f.get(target), damage);
    }
}