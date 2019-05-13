package fr.alegent.Swingy.Models;

import fr.alegent.Swingy.Services.ResourcesService;
import fr.alegent.Swingy.Services.SavesServices;

public class State {
    public final Enemy[] enemies;
    public final Item[] items;
    public final Save[] saves;
    public Coordinate coordinate;
    public Player player;
    public Enemy enemy;
    public Stage stage;
    public Map map;

    public State() throws Exception {
        enemies = ResourcesService.shared.get("enemies.json", Enemy[].class);
        items = ResourcesService.shared.get("items.json", Item[].class);
        saves = SavesServices.get();
    }

    public enum Stage {
        QUIT, START, NEW_CHARACTER, LOAD_CHARACTER, MISSION_GENERATION,
        FREE_MODE, MOVE, STATS, INVENTORY, EQUIP, UNEQUIP, CHECK, FIGHT,
        LEVEL_UP
    }

}
