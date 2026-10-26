package restaurant.application;

import restaurant.domain.TableReservation;

public interface ReservationRepository {
    void save(TableReservation reservation);
}
