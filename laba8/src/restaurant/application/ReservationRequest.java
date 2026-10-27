package restaurant.application;

public record ReservationRequest(String guestName, String timeSlot, int guestsCount) {
}
