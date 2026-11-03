package task1;

import common.Logger;

 //Creator. Процес спавну описаний один раз (spawn)
public abstract class Location {
    private final String name;
    private final String[] spawnPoints;
    private int spawned = 0;
    protected Location(String name, String... spawnPoints) {
        this.name = name;
        this.spawnPoints = spawnPoints;
    }
    // Фабричний метод - перевизначається в підкласах.  Вирішує, який саме монстр створюється.
    protected abstract Monster createMonster();
    // Загальний процес спавну: не знає конкретних класів монстрів
    public final Monster spawn(World world) {
        if (world.isFull()) {                                        
            Logger.log("Spawn", "Ліміт монстрів (" + world.getLimit() + ") досягнуто, спавн у «" + name + "» скасовано");
            return null;
        }
        String point = spawnPoints[spawned++ % spawnPoints.length];   //обрати точку появи
        Monster monster = createMonster();                            
        world.add(monster);                                           
        Logger.log("Spawn", "Локація «" + name + "», точка «" + point + "»: з'явився " + monster);
        return monster;
    }
}