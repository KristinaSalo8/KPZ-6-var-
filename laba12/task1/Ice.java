package task1;
import common.Logger;
//ConcreteImplementor - стихія «Криги»
public class Ice implements Element {
    @Override public String getName() { return "Криги"; }
    @Override public void affect(String target) {
        Logger.log("Криги", "Ефект на " + target + ": уповільнення (швидкість -50%)");
    }
}