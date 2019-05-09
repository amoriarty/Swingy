package fr.alegent.Swingy.Models;

public class State {
    public Stage stage;
    public Player player;
    public int mission = 0;
    public Map map;

    public enum Stage {
        QUIT,
        NEW_CHARACTER,
        MISSION_GENERATION,
        FREE_MODE
    }
}
