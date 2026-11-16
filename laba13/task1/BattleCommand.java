package task1;

import java.util.Map;

// Дія гравця в бою - знає, як виконатися і як скасуватися
public interface BattleCommand {
    void execute();
    void undo();
    String describe();
    //Та сама дія для інших персонажів (потрібно для повтору бою).
    BattleCommand copyFor(Map<Fighter, Fighter> fighters);
}