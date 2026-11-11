package task1;
import common.Logger;

// Нова стихія «Отрута» 
public class Poison implements Element {
    @Override public String getName() { return "Отрути"; }
    @Override public void affect(String target) {
        Logger.log("Отрути", "Ефект на " + target + ": отруєння (шкода з часом)");
    }
}