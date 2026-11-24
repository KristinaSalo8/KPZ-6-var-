package task2;
import java.util.List;

//Новий тип підземелля
public class Swamp extends Dungeon {
    @Override protected String getName() { return "Болото"; }
    @Override protected int getRequiredLevel() { return 3; }
    @Override protected List<String> generateRooms() { return List.of("Туманна стежка", "Трясовина"); }
    @Override protected String getBoss() { return "Болотна відьма"; }
}