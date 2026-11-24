package task1;
import common.Logger;

// Context: монстр. Лише делегує поведінку поточному стану - жодних розгалужень за станом
public class Monster {
    private final String name;
    private final int maxHp;
    private int hp;
    private int distanceFromSpawn;
    private MonsterState state;
    public Monster(String name, int hp, MonsterState initial) {
        this.name = name;
        this.maxHp = hp;
        this.hp = hp;
        this.state = initial;
        Logger.log(name, "З'явився у стані «" + initial.getName() + "»");
    }
    // Делегує оновлення поточному стану, передаючи себе (this) та відстань до гравця
    public void update(int playerDistance) { state.update(this, playerDistance); }
    public void setState(MonsterState next) {
        Logger.log(name, "Перехід: «" + state.getName() + "» → «" + next.getName() + "»");
        state = next;
    }
    public void takeDamage(int damage) {
        hp = Math.max(0, hp - damage);
        Logger.log(name, "Отримав " + damage + " шкоди, здоров'я " + hp + "/" + maxHp);
    }
    // Здоров'я нижче 20%
    public boolean isLowHealth() { return hp * 5 < maxHp; }
    public void moveFromSpawn(int delta) { distanceFromSpawn = Math.max(0, distanceFromSpawn + delta); }
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getDistanceFromSpawn() { return distanceFromSpawn; }
}