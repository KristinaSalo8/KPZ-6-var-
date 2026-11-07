package task2;

// Результат покупки у форматі магазину гри
public class PurchaseResult {
    final boolean success;
    final String transactionId;
    public PurchaseResult(boolean success, String transactionId) {
        this.success = success;
        this.transactionId = transactionId;
    }
    @Override public String toString() {
        return (success ? "успіх" : "відмова") + ", транзакція " + transactionId;
    }
}
