package restaurant.infrastructure;

import restaurant.application.NotificationService;
import restaurant.application.ReservationRepository;
import restaurant.domain.TableReservation;
public class NotifyingReservationRepository implements ReservationRepository {
    private final ReservationRepository inner;
    private final NotificationService notifier;

    public NotifyingReservationRepository(ReservationRepository inner, NotificationService notifier) {
        this.inner = inner;
        this.notifier = notifier;
    }

    @Override
    public void save(TableReservation r) {
        inner.save(r);
        notifier.send(r.guestPhone(), "Деталі резерву #" + r.id());
    }
}
