package fr.alegent.Swingy.Models;

import java.util.HashMap;

public class Map {
    private HashMap<Coordinate, Item> items = new HashMap<>();
    private HashMap<Coordinate, ?> ennemies = new HashMap<>();
    private final int size;

    public Map(int mission) {
        this.size = mission * 5;
    }
}
