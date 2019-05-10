package fr.alegent.Swingy.Models;

import fr.alegent.Swingy.Services.ResourcesService;
import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Map {
    public final HashMap<Coordinate, Item> items = new HashMap<>();
    public final HashMap<Coordinate, Enemy> enemies = new HashMap<>();
    public final Integer size;

    public Map(int mission) throws Exception {
        val size = mission * 6;
        val player = new Coordinate(size / 2, size / 2);
        val items = ResourcesService.shared.get("items.json", Item[].class);
        val allEnemies = ResourcesService.shared.get("enemies.json", Enemy[].class);
        val enemies = new ArrayList<Enemy>();
        this.size = size;

        for (val enemy: allEnemies) {
            if (enemy.level > mission) continue;
            enemies.add(enemy);
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

            val seed = new Random().nextInt(enemies.size());
            val enemy = enemies.get(seed);
            this.enemies.put(coordinate, enemy);
        }
    }

}
