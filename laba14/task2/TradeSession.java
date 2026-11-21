package task2_mediator;

import common.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** ConcreteMediator: вікно обміну двох гравців. Обмін або виконується повністю, або не виконується. */
public class TradeSession implements TradeMediator {
    private static final String SOURCE = "Координатор обміну";

    private final Trader a;
    private final Trader b;
    private final Map<Trader, Offer> offers = new HashMap<>();
    private final Set<Trader> confirmed = new HashSet<>();
    private boolean finished;

    public TradeSession(Trader a, Trader b) {
        this.a = a;
        this.b = b;
        a.setMediator(this);
        b.setMediator(this);
        Logger.log(SOURCE, "Відкрито обмін: " + a.getName() + " ⇄ " + b.getName());
    }

    @Override public void offerChanged(Trader from, Offer offer) {
        if (finished) { ignore(from); return; }
        offers.put(from, offer);
        Logger.log(SOURCE, "Прийнято пропозицію від " + from.getName());
        if (!confirmed.isEmpty()) {
            confirmed.clear();
            Logger.log(SOURCE, "Пропозицію змінено - підтвердження обох сторін скинуто");
        }
    }

    @Override public void confirm(Trader from) {
        if (finished) { ignore(from); return; }
        if (!offers.containsKey(from)) {
            Logger.log(SOURCE, from.getName() + " ще не зробив пропозицію - підтвердження відхилено");
            return;
        }
        confirmed.add(from);
        Logger.log(SOURCE, "Підтвердження від " + from.getName() + " (" + confirmed.size() + "/2)");
        if (confirmed.size() == 2) execute();
    }

    @Override public void disconnect(Trader from) {
        if (finished) { ignore(from); return; }
        finish("Обмін СКАСОВАНО: " + "гравець " + from.getName() + " відключився, предмети на місці");
    }

    private void execute() {
        Offer offerA = offers.get(a);
        Offer offerB = offers.get(b);
        if (!a.canGive(offerA) || !b.canGive(offerB)) {
            finish("Обмін СКАСОВАНО: у когось немає запропонованих предметів чи золота");
            return;
        }
        a.give(offerA);
        b.give(offerB);
        a.receive(offerB);
        b.receive(offerA);
        finish("Обмін ВИКОНАНО: " + a.getName() + " віддає (" + offerA + "), " + b.getName() + " віддає (" + offerB + ")");
    }

    private void finish(String result) {
        finished = true;
        Logger.log(SOURCE, result);
        Logger.log("Журнал транзакцій", result);
    }

    private void ignore(Trader from) {
        Logger.log(SOURCE, "Обмін уже завершено, дію " + from.getName() + " проігноровано");
    }
}
