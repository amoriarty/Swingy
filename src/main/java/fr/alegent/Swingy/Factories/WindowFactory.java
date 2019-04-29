package fr.alegent.Swingy.Factories;

import fr.alegent.Swingy.Controllers.ConsoleController;
import fr.alegent.Swingy.Controllers.GUIController;
import fr.alegent.Swingy.Interfaces.WindowInterface;
import fr.alegent.Swingy.Models.WindowMode;
import lombok.val;

/**
 * Factory to create window controllers based on program arguments.
 */
public class WindowFactory {

    /**
     * Create a visual interface from value passed as program parameter.
     * @param value: Parameter passed to program.
     * @return Controller based on mode asked.
     */
    public static WindowInterface make(String value) throws InvalidModeException {
        val mode = WindowMode.valueOf(value.toUpperCase());
        switch (mode) {
            case CONSOLE: return new ConsoleController();
            case GUI: return new GUIController();
            default: throw new InvalidModeException();
        }
    }

    /**
     * Exception throw when mode isn't either GUI or console.
     */
    private static class InvalidModeException extends Exception { }

}
