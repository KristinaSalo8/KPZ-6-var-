package task2;

// Mediator: єдиний координуючий об'єкт обміну
public interface TradeMediator {
    void offerChanged(Trader from, Offer offer);

    void confirm(Trader from);

    void disconnect(Trader from);
}
