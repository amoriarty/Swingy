package fr.alegent.Swingy.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.val;

import java.util.HashMap;
import java.util.Random;

@Getter
@Setter
public class Map {
    private HashMap<Coordinate, Item> items = new HashMap<>();
    private HashMap<Coordinate, ?> enemies = new HashMap<>();
    private final int size;

    public Map(int mission) throws Exception {
        val size = mission * 6;
        val playerCoordinate = new Coordinate(size / 2, size / 2);
        this.size = size;

        for (int i = 0; i < size; i++) {
            val itemCoordinate = Coordinate.random(size);

            if (!itemCoordinate.equals(playerCoordinate)) {
                val seed = new Random().nextInt(Item.allCases.size());
                val item = Item.allCases.get(seed).getDeclaredConstructor().newInstance();
                items.put(Coordinate.random(size), item);
            }
        }
    }
}
