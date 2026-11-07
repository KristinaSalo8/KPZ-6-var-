package task2;
import common.Logger;

// Adaptee №2 - друга стороння платформа з іншим API (повна сума в одиницях валюти, код 0 = успіх)
public class ZetaPay {
    private String lastReceipt = "";
    public int sendMoney(String isoCurrency, double majorUnits) {
        lastReceipt = "ZP-" + Math.round(majorUnits * 7);
        Logger.log("ZetaPay", "sendMoney(\"" + isoCurrency + "\", " + majorUnits + ") → код 0, квитанція " + lastReceipt);
        return 0;
    }
    public String lastReceipt() { return lastReceipt; }
}
