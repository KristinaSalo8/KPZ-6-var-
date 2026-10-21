import java.math.BigDecimal;

public class Task4_ISP {
    interface CardPayment { void processCreditCard(BigDecimal amount, String cardNumber); }
    interface NfcPayment { void processNfcTap(BigDecimal amount); }
    interface BankTransferPayment { void processBankTransfer(BigDecimal amount, String iban); }
    interface GiftCardPayment { void processGiftCard(BigDecimal amount, String voucherCode); }
    interface ReceiptPrinter { void printPaperReceipt(String text); }
    static class OnlineWebCheckoutTerminal implements CardPayment, BankTransferPayment {
        public void processCreditCard(BigDecimal amount, String cardNumber) {
            System.out.println("Web charged " + amount + " via card.");
        }
        public void processBankTransfer(BigDecimal amount, String iban) {
            System.out.println("Web charged " + amount + " via IBAN.");
        }
    }
    static class PosCardReader implements CardPayment, NfcPayment, ReceiptPrinter {
        public void processCreditCard(BigDecimal amount, String cardNumber) {
            System.out.println("POS processed card " + amount + ".");
        }
        public void processNfcTap(BigDecimal amount) {
            System.out.println("POS read NFC tap " + amount + ".");
        }
        public void printPaperReceipt(String text) {
            System.out.println("Printed receipt: " + text);
        }
    }
    static class CheckoutService {
        void payByCard(CardPayment terminal, BigDecimal amount, String card) {
            terminal.processCreditCard(amount, card);
        }
    }
    static class ContactlessCashier {
        void payAndPrint(NfcPayment pay, ReceiptPrinter printer, BigDecimal amount) {
            pay.processNfcTap(amount);
            printer.printPaperReceipt("NFC payment: " + amount);
        }
    }
    public static void main(String[] args) {
        OnlineWebCheckoutTerminal web = new OnlineWebCheckoutTerminal();
        PosCardReader pos = new PosCardReader();
        CheckoutService checkout = new CheckoutService();
        checkout.payByCard(web, new BigDecimal("150.00"), "4111-1111-1111-1111");
        checkout.payByCard(pos, new BigDecimal("75.50"), "4222-2222-2222-2222");
        new ContactlessCashier().payAndPrint(pos, pos, new BigDecimal("20.00"));
        web.processBankTransfer(new BigDecimal("500.00"), "UA213223130000026007233566001");
    }
}