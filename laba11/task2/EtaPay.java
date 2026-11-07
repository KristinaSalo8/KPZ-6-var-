package task2;
import common.Logger;

// Adaptee №2 - друга стороння платформа з іншим API (повна сума в одиницях валюти, код 0 = успіх)
public class EtaPay {
    private String lastReceipt = "";
    public int sendMoney(String isoCurrency, double majorUnits) {
        lastReceipt = "EP-" + Math.round(majorUnits * 7);
        Logger.log("EtaPay", "sendMoney(\"" + isoCurrency + "\", " + majorUnits + ") → код 0, квитанція " + lastReceipt);
        return 0;
    }
    public String lastReceipt() { return lastReceipt; }
}
