package restaurant.domain;

/** Protected Variations: стабільний контракт для змінної цінової політики часу візиту. */
public interface TimeSlotPolicy {
    double applyDiscount(double amount);
}
