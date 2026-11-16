package task1;
import common.Logger;
import java.util.Map;
//ConcreteCommand: використання зілля
public class PotionCommand implements BattleCommand {
    private final Fighter actor;
    private final int heal;
    private int healed;
    public PotionCommand(Fighter actor, int heal) {
        this.actor = actor;
        this.heal = heal;
    }
    @Override public void execute() {
        actor.addPotions(-1);
        healed = actor.heal(heal);
        Logger.log(actor.getName(), "Зілля: +" + healed + " HP (тепер " + actor.getHp() + "), зілля лишилось " + actor.getPotions());
    }
    @Override public void undo() {
        actor.takeDamage(healed);
        actor.addPotions(1);
        Logger.log(actor.getName(), "Скасування зілля: HP " + actor.getHp() + ", зілля повернуто (" + actor.getPotions() + ")");
    }
    @Override public String describe() { return actor.getName() + ": зілля лікування (" + heal + ")"; }
    @Override public BattleCommand copyFor(Map<Fighter, Fighter> f) {
        return new PotionCommand(f.get(actor), heal);
    }
}