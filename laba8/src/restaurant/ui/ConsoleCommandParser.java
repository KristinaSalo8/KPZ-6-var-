package restaurant.ui;

import restaurant.application.ReservationRequest;
public class ConsoleCommandParser {
    public ReservationRequest parse(String guestName, String timeSlot, String guestsCount) {
        try {
            return new ReservationRequest(guestName.trim(), timeSlot.trim(),
                    Integer.parseInt(guestsCount.trim()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Кількість гостей має бути цілим числом");
        }
    }
}
