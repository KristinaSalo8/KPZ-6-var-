package task2_flyweight;

import java.util.ArrayList;
import java.util.List;

/** Локація (клієнт): розміщує об'єкти рослинності, отримуючи види з фабрики. */
public class Landscape {
    private final PlantTypeFactory factory = new PlantTypeFactory();
    private final List<PlantInstance> plants = new ArrayList<>();

    public PlantInstance plant(String type, double x, double y, double scale, double rotation) {
        PlantInstance p = new PlantInstance(factory.getType(type), x, y, scale, rotation);
        plants.add(p);
        return p;
    }

    public List<PlantInstance> getPlants() { return plants; }

    public PlantTypeFactory getFactory() { return factory; }
}
