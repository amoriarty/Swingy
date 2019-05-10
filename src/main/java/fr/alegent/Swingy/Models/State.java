package fr.alegent.Swingy.Models;

public class State {
    public Coordinate coordinate;
    public Integer mission = 1;
    public Player player;
    public Stage stage;
    public Enemy enemy;
    public Map map;

    public enum Stage {
        QUIT, NEW_CHARACTER, MISSION_GENERATION, FREE_MODE, MOVE,
        STATS, INVENTORY, EQUIP, UNEQUIP, CHECK, FIGHT
    }

}
