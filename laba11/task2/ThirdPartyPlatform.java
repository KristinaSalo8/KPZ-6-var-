package task2;
import common.Logger;

// Adaptee №1 - стороння платформа: центи, код валюти, власний формат відповіді. */
public class ThirdPartyPlatform {
    private int counter = 1000;
    public static class PlatformResponse {
        final int statusCode;
        final String reference;
        PlatformResponse(int statusCode, String reference) {
            this.statusCode = statusCode;
            this.reference = reference;
        }
    }
    public PlatformResponse executeCharge(long amountInCents, String currencyCode) {
        PlatformResponse r = new PlatformResponse(200, "PF-" + (++counter));
        Logger.log("ThirdPartyPlatform", "executeCharge(" + amountInCents + ", \"" + currencyCode + "\") → статус " + r.statusCode + ", ref " + r.reference);
        return r;
    }
}
