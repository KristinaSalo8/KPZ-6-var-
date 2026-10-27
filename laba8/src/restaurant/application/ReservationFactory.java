package restaurant.application;

import restaurant.domain.Guest;
import restaurant.domain.MenuItem;
import restaurant.domain.OrderLine;
import restaurant.domain.TableReservation;
import restaurant.domain.TimeSlot;

import java.util.List;

public class ReservationFactory {
    private static final String DEMO_PHONE = "+380631234567";
    private int nextId = 404;

    public TableReservation create(ReservationRequest request) {
        Guest guest = new Guest(3, request.guestName(), DEMO_PHONE);
        List<OrderLine> preOrder = List.of(
                new OrderLine(new MenuItem("Стейк Рібай", 650.0, "Main"), 4),
                new OrderLine(new MenuItem("Вино Червоне", 400.0, "Drink"), 2));
        return TableReservation.create(nextId++, guest, request.guestsCount(),
                TimeSlot.parse(request.timeSlot()), preOrder);
    }
}
