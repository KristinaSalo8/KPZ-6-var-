package restaurant.domain;

/** Protected Variations: захищає код від змін вимог */
public interface TimeSlotPolicy {
    double applyDiscount(double amount);
}
