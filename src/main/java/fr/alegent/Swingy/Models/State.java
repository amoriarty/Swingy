package fr.alegent.Swingy.Models;

public class State {
    public Stage stage;
    public Player player;
    public int mission = 0;
    public Map map;
    public Enemy enemy;
    public Coordinate coordinate;

    public enum Stage {
        QUIT,
        NEW_CHARACTER,
        MISSION_GENERATION,
        FREE_MODE,
        MOVE,
        STATS,
        INVENTORY,
        EQUIP,
        UNEQUIP,
        CHECK,
        FIGHT
    }

}
