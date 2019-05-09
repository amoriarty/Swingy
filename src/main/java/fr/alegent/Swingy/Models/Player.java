package fr.alegent.Swingy.Models;

public class Player {
    public final String name;
    public final Origin origin;
    public Coordinate coordinate;

    public Player(String name, Origin origin) {
        this.name = name;
        this.origin = origin;
    }
}
