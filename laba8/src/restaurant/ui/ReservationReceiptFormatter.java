package restaurant.ui;

import restaurant.domain.TableReservation;

import java.util.Locale;
public class ReservationReceiptFormatter {
    public String format(TableReservation r) {
        return String.format(Locale.ROOT,
                "Чек резерву #%d%n"
                        + "Гість: %s (%d осіб)%n"
                        + "Страви: %.2f грн%n"
                        + "Обслуговування: %.2f грн%n"
                        + "Всього до сплати: %.2f грн",
                r.id(), r.guestName(), r.guestsCount(),
                r.foodSubtotal(), r.serviceCharge(), r.totalBill());
    }
}
