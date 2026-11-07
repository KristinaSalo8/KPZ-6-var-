package task2;
import common.Logger;

//Adapter №2 - підключення ще однієї платформи без змін у магазині
public class ZetaPayAdapter implements PaymentGateway {
    private final ZetaPay zeta = new ZetaPay();
    @Override public PurchaseResult purchase(String player, double amountUah, int gameCurrency) {
        Logger.log("ZetaPayAdapter", "Передаємо " + amountUah + " грн у ZetaPay");
        int code = zeta.sendMoney("UAH", amountUah);
        PurchaseResult result = new PurchaseResult(code == 0, zeta.lastReceipt());
        Logger.log("ZetaPayAdapter", "Код " + code + " → " + result);
        return result;
    }
}
