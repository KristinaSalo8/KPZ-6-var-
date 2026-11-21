package task2_mediator;

import common.Logger;
import java.util.ArrayList;
import java.util.List;

/** Colleague: гравець-учасник обміну. Звертається лише до посередника, а не до іншого гравця. */
public class Trader {
    private final String name;
    private final List<String> items = new ArrayList<>();
    private int gold;
    private TradeMediator mediator;

    public Trader(String name, int gold, String... items) {
        this.name = name;
        this.gold = gold;
        this.items.addAll(List.of(items));
    }

    public String getName() { return name; }

    public void setMediator(TradeMediator mediator) { this.mediator = mediator; }

    /* --- дії гравця (йдуть через посередника) --- */

    public void propose(int gold, String... items) {
        Offer offer = new Offer(List.of(items), gold);
        Logger.log(name, "Пропоную: " + offer);
        mediator.offerChanged(this, offer);
    }

    public void confirm() {
        Logger.log(name, "Підтверджую обмін");
        mediator.confirm(this);
    }

    public void disconnect() {
        Logger.log(name, "Відключаюсь від обміну");
        mediator.disconnect(this);
    }

    /* --- інвентар (викликає посередник) --- */

    public boolean canGive(Offer o) {
        return items.containsAll(o.getItems()) && gold >= o.getGold();
    }

    public void give(Offer o) {
        items.removeAll(o.getItems());
        gold -= o.getGold();
    }

    public void receive(Offer o) {
        items.addAll(o.getItems());
        gold += o.getGold();
    }

    @Override public String toString() { return name + ": предмети " + items + ", золото " + gold; }
}
