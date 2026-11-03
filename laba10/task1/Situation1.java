package task1;
import common.Logger;
import java.util.List;

public class Situation1 {
    public static void run() {
        World world = new World(5);
        List<Location> locations = List.of(new Locations.Forest(), new Locations.Swamp(), new Locations.Mountains());
        for (Location l : locations) {
            l.spawn(world);
        }
        Logger.log("Game", "Додано новий тип локації «Пустеля»");
        Location wasteland = new WastelandLocation();
        wasteland.spawn(world);
        // Ліміт
        locations.get(0).spawn(world);
        locations.get(1).spawn(world); 
        System.out.println("Монстри у світі (" + world.getMonsters().size() + "/" + world.getLimit() + "):");
        for (Monster m : world.getMonsters()) System.out.println("  - " + m);
    }
}