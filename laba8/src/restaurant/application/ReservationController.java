package restaurant.application;

import restaurant.domain.TableReservation;

public class ReservationController {
    private final ReservationFactory factory;
    private final ReservationRepository repository;

    public ReservationController(ReservationFactory factory, ReservationRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    public TableReservation reserve(ReservationRequest request) {
        TableReservation reservation = factory.create(request);
        repository.save(reservation);
        return reservation;
    }
}
