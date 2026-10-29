package restaurant.domain;

/** Polymorphism: кожен час має свою знижку (замість if-else) */
public enum TimeSlot implements TimeSlotPolicy {
    HAPPYHOURS { //знижка 15%
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
    EVENING { //+10% до ціни
        @Override
        public double applyDiscount(double amount) {
            return amount * 1.10;
        }
    };
    // перевірка що час введенно вірно
    public static TimeSlot parse(String text) {
        try {
            return valueOf(text.trim().toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Невідомий час відвідування: " + text);
        }
    }
}
