package task1;
import common.Logger;
import java.util.List;
//RefinedAbstraction - удар по площі
public class AreaStrike extends Skill {
    public AreaStrike(Element element) { super(element); }
    @Override public void use(String caster, List<String> targets) {
        Logger.log("AreaStrike", caster + " б'є по площі, цілей: " + targets.size() + " (стихія: " + element.getName() + ")");
        for (String t : targets) element.affect(t);
    }
}