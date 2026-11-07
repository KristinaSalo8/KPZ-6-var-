package task2;

// Target - власний інтерфейс покупки магазину (сума в гривнях, кількість ігрової валюти)
public interface PaymentGateway {
    PurchaseResult purchase(String player, double amountUah, int gameCurrency);
}
