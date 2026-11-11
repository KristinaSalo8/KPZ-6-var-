package task2_flyweight;

import java.util.HashMap;
import java.util.Map;

/** Роль: FlyweightFactory. Видає вже створений вид, новий створює лише при першому запиті. */
public class PlantTypeFactory {
    private final Map<String, PlantType> types = new HashMap<>();

    public PlantType getType(String name) {
        return types.computeIfAbsent(name, PlantType::new);
    }

    public int getTypeCount() { return types.size(); }

    public long getTypeSizeBytes(String name) { return types.get(name).getSizeBytes(); }
}
