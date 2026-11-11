package task1;
import common.Logger;
// ConcreteImplementor - стихія «Вогонь»
public class Fire implements Element {
    @Override public String getName() { return "Вогонь"; }
    @Override public void affect(String target) {
        Logger.log("Вогонь", "Ефект на " + target + ": підпал (втрачає здоров'я щосекунди)");
    }
}
