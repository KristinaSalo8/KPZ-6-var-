package task1;
import common.Logger;
import java.util.Map;

//ConcreteCommand: рух
public class MoveCommand implements BattleCommand {
    private final Fighter actor;
    private final int dx;
    public MoveCommand(Fighter actor, int dx) {
        this.actor = actor;
        this.dx = dx;
    }
    @Override public void execute() {
        actor.moveBy(dx);
        Logger.log(actor.getName(), "Рух на " + dx + " → позиція " + actor.getPosition());
    }
    @Override public void undo() {
        actor.moveBy(-dx);
        Logger.log(actor.getName(), "Скасування руху → позиція " + actor.getPosition());
    }
    @Override public String describe() { return actor.getName() + ": рух на " + dx; }
    @Override public BattleCommand copyFor(Map<Fighter, Fighter> f) {
        return new MoveCommand(f.get(actor), dx);
    }
}
