package task1;
import common.Logger;

// ConcreteImplementor - стихія «Блискавки»
public class Lightning implements Element {
    @Override public String getName() { return "Блискавки"; }
    @Override public void affect(String target) {
        Logger.log("Блискавки", "Ефект на " + target + ": оглушення (2 секунди)");
    }
}