package task1_prototype;
import common.Logger;
import java.util.ArrayList;
import java.util.List;
// ConcretePrototype

public class Monster implements Prototype<Monster> {
    private String species;
    private int level;
    private Weapon weapon;
    private List<String> skills = new ArrayList<>();
    private List<String> loot = new ArrayList<>();
    public Monster(String species, int level, Weapon weapon, List<String> skills, List<String> loot) {
        Logger.log("Monster", "Дороге завантаження моделі, анімацій і характеристик: " + species);
        Logger.sleep(300);
        this.species = species;
        this.level = level;
        this.weapon = weapon;
        this.skills.addAll(skills);
        this.loot.addAll(loot);
    }

    // Конструктор для глибокого копіювання
    private Monster(Monster o) {
        this.species = o.species;
        this.level = o.level;
        this.weapon = new Weapon(o.weapon);
        this.skills = new ArrayList<>(o.skills);
        this.loot = new ArrayList<>(o.loot);
    }
    @Override 
    public Monster copy() { 
        return new Monster(this); 
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public List<String> getSkills() {
        return skills;
    }
    @Override 
    public String toString() {
        return species + " [рівень " + level + ", зброя " + weapon + ", уміння " + skills + ", лут " + loot + "]";
    }
}