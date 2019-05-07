package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Exceptions.InvalidGameMode;

public class GameController {
    private final Mode mode;

    enum Mode {
        CONSOLE, GUI
    }

    public GameController(String mode) throws InvalidGameMode {
        try { this.mode = Mode.valueOf(mode); }
        catch (Exception exception) { throw new InvalidGameMode(); }
    }

    public void start() {

    }

}
