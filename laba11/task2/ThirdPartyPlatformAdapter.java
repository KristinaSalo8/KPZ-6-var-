package task2;
import common.Logger;

// Adapter №1. Перетворення суми і формату відповіді виконується тільки тут
public class ThirdPartyPlatformAdapter implements PaymentGateway {
    private final ThirdPartyPlatform platform = new ThirdPartyPlatform();
    @Override public PurchaseResult purchase(String player, double amountUah, int gameCurrency) {
        long cents = Math.round(amountUah * 100);
        Logger.log("ThirdPartyPlatformAdapter", amountUah + " грн → " + cents + " центів, валюта \"UAH\"");
        ThirdPartyPlatform.PlatformResponse r = platform.executeCharge(cents, "UAH");
        PurchaseResult result = new PurchaseResult(r.statusCode == 200, r.reference);
        Logger.log("ThirdPartyPlatformAdapter", "Відповідь платформи (" + r.statusCode + ") → " + result);
        return result;
    }
}
