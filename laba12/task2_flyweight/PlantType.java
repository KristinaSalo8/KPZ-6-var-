package task2_flyweight;

import common.Logger;

/** Роль: Flyweight. Внутрішній (спільний) стан виду: модель, текстура, анімація вітру. */
public class PlantType {
    private static final int ASSET_SIZE = 50_000; // умовний розмір кожного ресурсу, байт

    private final String name;
    private final byte[] model = new byte[ASSET_SIZE];
    private final byte[] texture = new byte[ASSET_SIZE];
    private final byte[] windAnimation = new byte[ASSET_SIZE];

    PlantType(String name) {
        this.name = name;
        Logger.log("PlantType", "Завантажено модель, текстуру й анімацію вітру виду «" + name + "» (один раз)");
    }

    public String getName() { return name; }

    public long getSizeBytes() { return (long) model.length + texture.length + windAnimation.length; }
}
