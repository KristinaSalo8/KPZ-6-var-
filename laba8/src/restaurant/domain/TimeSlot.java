package restaurant.domain;

/** Polymorphism: кожен часовий слот сам знає свою знижку (замість if-else). */
public enum TimeSlot implements TimeSlotPolicy {
    HAPPYHOURS {
        @Override
        public double applyDiscount(double amount) {
            return amount * 0.85;
        }
    },
    STANDARD {
        @Override
        public double applyDiscount(double amount) {
            return amount;
        }
    },
    EVENING {
        @Override
        public double applyDiscount(double amount) {
            return amount;
        }
    };

    public static TimeSlot parse(String text) {
        try {
            return valueOf(text.trim().toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Невідомий час відвідування: " + text);
        }
    }
}
