package task1;
import common.Logger;
import java.util.List;
//RefinedAbstraction - удар по одній цілі
public class SingleTargetStrike extends Skill {
    public SingleTargetStrike(Element element) { super(element); }
    @Override public void use(String caster, List<String> targets) {
        String target = targets.get(0);
        Logger.log("SingleTargetStrike", caster + " б'є по цілі " + target + " (стихія: " + element.getName() + ")");
        element.affect(target);
    }
}