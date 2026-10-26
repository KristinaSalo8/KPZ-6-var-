package restaurant.domain;
import java.util.List;

public final class TableReservation {
    private static final int LARGE_GROUP_FROM = 5;
    private static final double SERVICE_RATE = 0.10;
    private final int id;
    private final Guest guest;
    private final int guestsCount;
    private final TimeSlotPolicy timeSlot;
    private final List<OrderLine> preOrder;
    private TableReservation(int id, Guest guest, int guestsCount,
                             TimeSlotPolicy timeSlot, List<OrderLine> preOrder) {
        this.id = id;
        this.guest = guest;
        this.guestsCount = guestsCount;
        this.timeSlot = timeSlot;
        this.preOrder = preOrder;
    }

    public static TableReservation create(int id, Guest guest, int guestsCount,
                                          TimeSlotPolicy timeSlot, List<OrderLine> preOrder) {
        if (guest == null || timeSlot == null) {
            throw new IllegalArgumentException("Гість і час відвідування обов'язкові");
        }
        if (guestsCount <= 0) {
            throw new IllegalArgumentException("Кількість гостей має бути додатною");
        }
        if (preOrder == null || preOrder.isEmpty()) {
            throw new IllegalArgumentException("Попереднє замовлення не може бути порожнім");
        }
        return new TableReservation(id, guest, guestsCount, timeSlot, List.copyOf(preOrder));
    }

    public double foodSubtotal() {
        double sum = 0.0;
        for (OrderLine line : preOrder) {
            sum += line.subtotal();
        }
        return timeSlot.applyDiscount(sum);
    }

    public double serviceCharge() {
        return guestsCount >= LARGE_GROUP_FROM ? foodSubtotal() * SERVICE_RATE : 0.0;
    }

    public double totalBill() {
        return foodSubtotal() + serviceCharge();
    }
    public int id() {
        return id;
    }

    public int guestsCount() {
        return guestsCount;
    }

    public String guestName() {
        return guest.name();
    }

    public String guestPhone() {
        return guest.phone();
    }
}
