package restaurant.application;
import restaurant.domain.TableReservation;
//Controller - Клас, який приймає вхідні запити від консольного UI, 
// обробляє їх за допомогою бізнес-логіки та повертає відповідний результат або сторінку у відповідь.
//Indirection (Непряме зв'язування через інтерфейси) - Працює з інтерфейсами, а не з конкретними реалізаціями, 
// що дозволяє легко змінювати реалізації без зміни контролера.
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
