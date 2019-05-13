package fr.alegent.Swingy.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.alegent.Swingy.Services.ResourcesService;
import lombok.RequiredArgsConstructor;
import lombok.val;

public class State {
    public Coordinate coordinate;
    public Integer mission = 1;
    public Player player;
    public Stage stage;
    public Map map;

    @JsonIgnore
    public final Enemy[] enemies;

    @JsonIgnore
    public final Item[] items;

    @JsonIgnore
    public Enemy enemy;

    public State() throws Exception {
        enemies = ResourcesService.shared.get("enemies.json", Enemy[].class);
        items = ResourcesService.shared.get("items.json", Item[].class);
    }

    public enum Stage {
        QUIT, NEW_CHARACTER, MISSION_GENERATION, FREE_MODE, MOVE,
        STATS, INVENTORY, EQUIP, UNEQUIP, CHECK, FIGHT
    }

}
