package fr.alegent.Swingy.Interfaces;

/**
 * Interface representing an abstract window, which can be launch and received current game state.
 */
public interface WindowInterface {

    /**
     * Launch visual interface.
     */
    void launch();

    /**
     * Set current controller.
     * @param controller Controller to set.
     */
    void setController(ControllerInterface controller);

}
