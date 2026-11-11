package task2_flyweight;

/** Об'єкт рослинності: зберігає лише власні (зовнішні) дані і посилання на спільний вид. */
public class PlantInstance {
    private static int created = 0; // скільки об'єктів рослинності фактично створено

    private final PlantType type;
    final double x, y, scale, rotation;

    PlantInstance(PlantType type, double x, double y, double scale, double rotation) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.rotation = rotation;
        created++;
    }

    public PlantType getType() { return type; }

    public static int getCreatedCount() { return created; }

    @Override public String toString() {
        return type.getName() + " (x=" + String.format("%.1f", x) + ", y=" + String.format("%.1f", y)
                + ", масштаб " + String.format("%.2f", scale) + ")";
    }
}
