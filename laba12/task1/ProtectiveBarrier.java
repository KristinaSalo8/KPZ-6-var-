package task1;
import common.Logger;
import java.util.List;
//RefinedAbstraction - захисний бар'єр
public class ProtectiveBarrier extends Skill {
    public ProtectiveBarrier(Element element) { super(element); }
    @Override public void use(String caster, List<String> attackers) {
        Logger.log("ProtectiveBarrier", caster + " ставить бар'єр (стихія: " + element.getName() + ")");
        for (String a : attackers) {
            Logger.log("ProtectiveBarrier", a + " атакує бар'єр");
            element.affect(a);
        }
    }
}