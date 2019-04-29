package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Interfaces.WindowInterface;
import fr.alegent.Swingy.Models.State;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Interface to console based game.
 * In order to simplified the all process, console will be considered as window in this all project.
 */
@Setter public class ConsoleController implements WindowInterface {
    @NotNull private State state;

    public void launch() {
        System.out.println("Launching game in console ...");
    }

}
