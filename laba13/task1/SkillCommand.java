package task1;
import common.Logger;
import java.util.Map;

// ConcreteCommand: застосування уміння
public class SkillCommand implements BattleCommand {
    private final Fighter actor;
    private final Fighter target;
    private final String skill;
    private final int damage;
    private int dealt;
    public SkillCommand(Fighter actor, Fighter target, String skill, int damage) {
        this.actor = actor;
        this.target = target;
        this.skill = skill;
        this.damage = damage;
    }
    @Override public void execute() {
        dealt = target.takeDamage(damage);
        Logger.log(actor.getName(), "Уміння «" + skill + "» → " + target.getName() + ": -" + dealt + " HP (залишилось " + target.getHp() + ")");
    }
    @Override public void undo() {
        target.heal(dealt);
        Logger.log(actor.getName(), "Скасування уміння «" + skill + "»: " + target.getName() + " знову має " + target.getHp() + " HP");
    }
    @Override public String describe() { return actor.getName() + ": уміння «" + skill + "» на " + target.getName(); }
    @Override public BattleCommand copyFor(Map<Fighter, Fighter> f) {
        return new SkillCommand(f.get(actor), f.get(target), skill, damage);
    }
}