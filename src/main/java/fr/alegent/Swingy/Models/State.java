package fr.alegent.Swingy.Models;

public class State {
    public Stage stage;
    public Player player;

    public enum Stage {
        QUIT,
        NEW_CHARACTER
    }
}
