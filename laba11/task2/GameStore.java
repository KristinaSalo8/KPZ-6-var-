package task2;
import common.Logger;
import java.util.HashMap;
import java.util.Map;

// Магазин гри. Працює лише з PaymentGateway і нічого не знає про сторонні платформи
public class GameStore {
    private static final double PRICE_PER_UNIT = 0.25;
    private final PaymentGateway gateway;
    private final Map<String, Integer> balances = new HashMap<>();
    public GameStore(PaymentGateway gateway) { this.gateway = gateway; }
    public void buyCurrency(String player, int amount) {
        double price = amount * PRICE_PER_UNIT;
        Logger.log("GameStore", player + " купує " + amount + " од. ігрової валюти за " + price + " грн");
        PurchaseResult result = gateway.purchase(player, price, amount);
        if (result.success) {
            balances.merge(player, amount, Integer::sum);
            Logger.log("GameStore", "Покупку отримано (" + result + "), гравцю нараховано " + amount + " валюти, баланс: " + balances.get(player));
        } else {
            Logger.log("GameStore", "Покупку відхилено: " + result);
        }
    }
}
