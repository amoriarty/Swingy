package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Interfaces.WindowInterface;
import fr.alegent.Swingy.Models.State;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Interface to GUI based game.
 */
@Setter public class GUIController implements WindowInterface {
    @NotNull private State state;

    public void launch() {
        System.out.println("GUI isn't implemented yet.");
    }

}
