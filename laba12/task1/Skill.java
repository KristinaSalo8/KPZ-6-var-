package task1;
import java.util.List;

// Abstraction. Вид уміння тримає посилання на стихію
public abstract class Skill {
    protected final Element element;
    protected Skill(Element element) { this.element = element; }
    public abstract void use(String caster, List<String> targets);
}