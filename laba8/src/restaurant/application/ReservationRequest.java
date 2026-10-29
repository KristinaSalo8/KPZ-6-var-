package restaurant.application;
//DTO (Data Transfer Object) - передача даних про бронювання між шарами додатку
public record ReservationRequest(String guestName, String timeSlot, int guestsCount) {
}
