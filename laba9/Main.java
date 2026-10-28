import java.util.*;

/* ======================= Журнал подій ======================= */
class Logger {
    private static int tick = 0; // умовний час (секунди)

    static void log(String source, String event) {
        tick += 5;
        System.out.printf("[%02d:%02d] [%s] %s%n", tick / 60, tick % 60, source, event);
    }

    static void sleep(int ms) { // емуляція "дорогої" операції
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}

/* ============ ЗАВДАННЯ 1: PROTOTYPE (спавн монстрів) ============ */

/** Роль: Prototype (інтерфейс клонування) */
interface Prototype<T> {
    T copy();
}

/** Вкладений об'єкт - екіпірування (глибоке копіювання) */
class Weapon {
    String name;
    int damage;

    Weapon(String name, int damage) { this.name = name; this.damage = damage; }

    Weapon(Weapon other) { this(other.name, other.damage); }

    @Override public String toString() { return name + "(" + damage + ")"; }
}

/** Роль: ConcretePrototype */
class Monster implements Prototype<Monster> {
    String species;
    int level;
    Weapon weapon;
    List<String> skills = new ArrayList<>();
    List<String> loot = new ArrayList<>();

    /** Дорогий конструктор: завантаження моделі, анімацій, характеристик */
    Monster(String species, int level, Weapon weapon, List<String> skills, List<String> loot) {
        Logger.log("Monster", "Дороге завантаження моделі, анімацій і характеристик: " + species);
        Logger.sleep(300);
        this.species = species;
        this.level = level;
        this.weapon = weapon;
        this.skills.addAll(skills);
        this.loot.addAll(loot);
    }

    /** Копіювальний конструктор: без завантаження, глибока копія вкладених даних */
    private Monster(Monster o) {
        this.species = o.species;
        this.level = o.level;
        this.weapon = new Weapon(o.weapon);
        this.skills = new ArrayList<>(o.skills);
        this.loot = new ArrayList<>(o.loot);
    }

    @Override public Monster copy() { return new Monster(this); }

    @Override public String toString() {
        return species + " [рівень " + level + ", зброя " + weapon + ", уміння " + skills + ", лут " + loot + "]";
    }
}

/* ============ ЗАВДАННЯ 2: SINGLETON (ігровий час світу) ============ */

/** Роль: Singleton */
class GameTime {
    private static GameTime instance;
    private int hour = 12;

    private GameTime() { // приватний - створити в обхід неможливо
        Logger.log("GameTime", "Ігровий час світу ініціалізовано");
    }

    static synchronized GameTime getInstance() {
        if (instance == null) instance = new GameTime();
        return instance;
    }

    void setHour(int hour) { this.hour = hour; }

    int getHour() { return hour; }

    boolean isNight() { return hour >= 20 || hour < 6; }

    String getId() { return "GT-" + Integer.toHexString(System.identityHashCode(this)); }
}

/* ============ ЗАВДАННЯ 3: OBJECT POOL (арени для матчів) ============ */

/** Роль: Reusable - об'єкт, який повторно використовується */
class Arena {
    final String id;
    String match;
    int scoreA, scoreB, timer;
    List<String> items = new ArrayList<>();
    int matchesPlayed = 0;

    /** Дорога підготовка: мапа, об'єкти, таймер */
    Arena(String id) {
        this.id = id;
        Logger.log("Arena", id + ": дорога підготовка (мапа, об'єкти, таймер)");
        Logger.sleep(300);
    }

    void start(String match) {
        this.match = match;
        this.items.add("аптечка");
        this.timer = 600;
        this.matchesPlayed++;
    }

    /** Скидання стану перед повторною видачею */
    void reset() {
        match = null;
        scoreA = scoreB = timer = 0;
        items.clear();
    }

    @Override public String toString() { return id + " (матч=" + match + ", рахунок " + scoreA + ":" + scoreB + ")"; }
}

/** Роль: ObjectPool. Стратегія черги: FIFO (чесно - хто раніше прийшов, той раніше грає). */
class ArenaPool {
    private final Queue<Arena> free = new LinkedList<>();
    private final Queue<String> waiting = new LinkedList<>();
    private final List<Arena> all = new ArrayList<>();

    ArenaPool(int size) {
        for (int i = 1; i <= size; i++) {
            Arena a = new Arena("A-" + i);
            all.add(a);
            free.add(a);
        }
    }

    /** Видати арену або поставити матч у чергу. Повертає арену чи null. */
    Arena acquire(String match) {
        Arena a = free.poll();
        if (a == null) {
            waiting.add(match);
            Logger.log("ArenaPool", "Вільних арен немає, матч '" + match + "' у черзі (позиція " + waiting.size() + ")");
            return null;
        }
        a.start(match);
        Logger.log("ArenaPool", "Арена " + a.id + " → матч " + match);
        return a;
    }

    /** Повернути арену: скинути стан і одразу віддати наступному в черзі. */
    void release(Arena a) {
        a.reset();
        Logger.log("ArenaPool", a.id + " повернено, стан скинуто");
        free.add(a);
        String next = waiting.poll();
        if (next != null) acquire(next);
    }

    void printStats() {
        Logger.log("ArenaPool", "Статистика:");
        for (Arena a : all) System.out.println("    " + a.id + ": матчів " + a.matchesPlayed);
        System.out.println("    Загальна кількість створених арен: " + all.size());
    }
}

/* ======================= Раннер ======================= */
public class Main {

    public static void main(String[] args) {
        System.out.println("===== Ситуація 1: Prototype (монстри) =====");
        situation1();
        System.out.println("\n===== Ситуація 2: Singleton (ігровий час) =====");
        situation2();
        System.out.println("\n===== Ситуація 3: Object Pool (арени) =====");
        situation3();
    }

    static void situation1() {
        Monster reference = new Monster("Вовк", 5, new Weapon("Ікла", 10),
                List.of("Вкус"), List.of("Шкура", "Ікло"));

        List<Monster> pack = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            pack.add(reference.copy());
        }
        Logger.log("Spawn", "На локації «Чорний ліс» з'явилося 5 вовків (без повторного завантаження)");

        Monster leader = pack.get(0);
        leader.weapon.name = "Кігті ватажка";
        leader.weapon.damage = 25;
        leader.level = 10;
        leader.skills.add("Виття");
        Logger.log("Spawn", "Вовк №1 став ватажком");

        System.out.println("Еталон:           " + reference);
        System.out.println("Ватажок:          " + leader);
        System.out.println("Звичайний вовк:   " + pack.get(1));
    }

    static void situation2() {
        GameTime weather = GameTime.getInstance();
        weather.setHour(22);
        Logger.log("Погода", "Світ переведено на 22:00, id часу = " + weather.getId());

        GameTime spawn = GameTime.getInstance();
        Logger.log("Спавн", "Час " + spawn.getHour() + ":00, id часу = " + spawn.getId());
        if (spawn.isNight()) Logger.log("Спавн", "Спавн нічних монстрів");
        else Logger.log("Спавн", "Спавн денних монстрів");

        GameTime trade = GameTime.getInstance();
        Logger.log("Торгівля", "id часу = " + trade.getId() + ", ніч: " + trade.isNight());

        GameTime quests = GameTime.getInstance();
        Logger.log("Квести", "id часу = " + quests.getId() + ", ніч: " + quests.isNight());
    }

    static void situation3() {
        ArenaPool pool = new ArenaPool(3);

        String[] matches = {"Вовки vs Ворони", "Леви vs Орли", "Тигри vs Яструби",
                "Ведмеді vs Лиси", "Круки vs Сови"};
        List<Arena> given = new ArrayList<>();
        for (String m : matches) {
            given.add(pool.acquire(m)); // 4-й і 5-й отримають null і стануть у чергу
        }

        // Імітуємо гру: перший матч завершується з рахунком 3:2
        Arena first = given.get(0);
        first.scoreA = 3;
        first.scoreB = 2;
        Logger.log("Match", "Матч '" + first.match + "' завершено з рахунком 3:2");
        pool.release(first);

        // Перевірка скидання: A-1 тепер у наступного матчу з рахунком 0:0
        Logger.log("Match", "Стан арени після повторної видачі: " + first);

        // Завершуємо решту, щоб черга повністю обслужилася
        pool.release(given.get(1));
        pool.release(first);
        pool.release(given.get(2));

        pool.printStats();
    }
}