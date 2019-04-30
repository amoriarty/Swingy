package fr.alegent.Swingy.Factories;

import fr.alegent.Swingy.Controllers.Console.CharacterCreationConsoleController;
import fr.alegent.Swingy.Interfaces.WindowControllerInterface;
import fr.alegent.Swingy.Models.Stage;
import fr.alegent.Swingy.Models.WindowMode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ControllerFactory {
    private final WindowMode mode;

    /**
     * Instantiate correct controller based on game stage.
     * @param stage Current game stage
     * @return Controller able to update state of from a game stage.
     */
    public WindowControllerInterface make(Stage stage) throws NoControllerAssociatedException {
        switch (mode) {
            case CONSOLE: return makeConsole(stage);
            case GUI: return null;
            default: throw new NoControllerAssociatedException();
        }
    }

    private WindowControllerInterface makeConsole(Stage stage) throws NoControllerAssociatedException {
        switch (stage) {
            case CHARACTER_CREATION: return new CharacterCreationConsoleController();
            case QUIT: return null;
            default: throw new NoControllerAssociatedException();
        }
    }

    private static class NoControllerAssociatedException extends Exception { }

}
