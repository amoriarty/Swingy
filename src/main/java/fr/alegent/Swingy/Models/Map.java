package fr.alegent.Swingy.Models;

import fr.alegent.Swingy.Services.ResourcesService;
import lombok.val;

import java.util.HashMap;
import java.util.Random;

public class Map {
    @SuppressWarnings({"FieldCanBeLocal", "MismatchedQueryAndUpdateOfCollection"})
    private final HashMap<Coordinate, Item> items = new HashMap<>();
    public final int size;


    public Map(int mission) throws Exception {
        val size = mission * 6;
        val player = new Coordinate(size / 2, size / 2);
        val items = ResourcesService.shared.get("items.json", Item[].class);
        this.size = size;

        for (int i = 0; i < size; i++) {
            val coordinate = Coordinate.random(size);
            if (coordinate.equals(player)) continue;

            val seed = new Random().nextInt(items.length);
            val item = items[seed];
            this.items.put(coordinate, item);
        }
    }

}
