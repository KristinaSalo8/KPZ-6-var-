package task2;
import common.Logger;

//Adapter №2 - підключення ще однієї платформи без змін у магазині
public class EtaPayAdapter implements PaymentGateway {
    private final EtaPay eta = new EtaPay();
    @Override public PurchaseResult purchase(String player, double amountUah, int gameCurrency) {
        Logger.log("ZetaPayAdapter", "Передаємо " + amountUah + " грн у ZetaPay");
        int code = eta.sendMoney("UAH", amountUah);
        PurchaseResult result = new PurchaseResult(code == 0, eta.lastReceipt());
        Logger.log("ZetaPayAdapter", "Код " + code + " → " + result);
        return result;
    }
}
