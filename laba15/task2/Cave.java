package task2;
import java.util.List;

// ConcreteClass: печера
public class Cave extends Dungeon {
    @Override protected String getName() { return "Печера"; }
    @Override protected int getRequiredLevel() { return 1; }
    @Override protected List<String> generateRooms() { return List.of("Вхідна зала", "Кажаняча галерея", "Підземне озеро"); }
    @Override protected String getBoss() { return "Печерний троль"; }
}