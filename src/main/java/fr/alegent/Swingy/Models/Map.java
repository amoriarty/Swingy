package fr.alegent.Swingy.Models;

import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Map {
    public final HashMap<Coordinate, Item> items = new HashMap<>();
    public final HashMap<Coordinate, Enemy> enemies = new HashMap<>();
    public final Integer size;

    // TODO: Based map size on player level, not current mission.
    public Map(int level, Item[] items, Enemy[] enemies) {
        val size = level * 6;
        val player = new Coordinate(size / 2, size / 2);
        val filteredEnemies = new ArrayList<Enemy>();
        this.size = size;

        for (val enemy: enemies) {
            if (enemy.level > level) continue;
            filteredEnemies.add(enemy);
        }

        for (int i = 0; i < size; i++) {
            val coordinate = Coordinate.random(size);
            if (coordinate.equals(player)) continue;

            val seed = new Random().nextInt(items.length);
            val item = items[seed];
            this.items.put(coordinate, item);
        }

        for (int i = 0; i < size; i++) {
            val coordinate = Coordinate.random(size);
            if (coordinate.equals(player)) continue;

            val seed = new Random().nextInt(filteredEnemies.size());
            val enemy = filteredEnemies.get(seed);
            this.enemies.put(coordinate, enemy);
        }
    }

}
