package fr.alegent.Swingy.Interfaces;

import fr.alegent.Swingy.Models.State;

public interface ControllerInterface {

    /**
     * Title of the current controller.
     * @return Title of the current controller.
     */
    String getTitle();

    /**
     * Idle function where user is asked for next state, and update it.
     * @param state Current game state.
     * @return New state after user interaction.
     */
    State update(State state) throws Exception;
}
