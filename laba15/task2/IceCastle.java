package task2;
import common.Logger;
import java.util.List;

// ConcreteClass: крижаний замок
public class IceCastle extends Dungeon {
    @Override protected String getName() { return "Крижаний замок"; }
    @Override protected int getRequiredLevel() { return 8; }
    @Override protected List<String> generateRooms() { return List.of("Крижаний хол", "Зала дзеркал", "Тронна зала", "Вежа вітрів"); }
    @Override protected String getBoss() { return "Крижаний лорд"; }
    @Override protected void placeTraps() {
        Logger.log(getName(), "Етап «Пастки»: власні пастки замку - крижані шипи і підлога, що ковзає");
    }
}