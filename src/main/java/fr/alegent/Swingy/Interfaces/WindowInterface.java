package fr.alegent.Swingy.Interfaces;

import fr.alegent.Swingy.Models.State;

/**
 * Interface representing an abstract window, which can be launch and received current game state.
 */
public interface WindowInterface {

    /**
     * Launch visual interface
     */
    void launch();

    /**
     * Set a game state to visually represent.
     * @param state: State to setup.
     */
    void setState(State state);
}
