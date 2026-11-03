package task1;
import java.util.ArrayList;
import java.util.List;

//зберігає монстрів і має ліміт
public class World {
    private final int limit;
    private final List<Monster> monsters = new ArrayList<>();
    public World(int limit) { this.limit = limit; }
    public boolean isFull() { return monsters.size() >= limit; }
    public void add(Monster m) { monsters.add(m); }
    public List<Monster> getMonsters() { return monsters; }
    public int getLimit() { return limit; }
}