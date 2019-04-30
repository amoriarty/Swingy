package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Factories.ControllerFactory;
import fr.alegent.Swingy.Factories.WindowFactory;
import fr.alegent.Swingy.Interfaces.WindowInterface;
import fr.alegent.Swingy.Models.Stage;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Models.WindowMode;
import lombok.val;

/**
 * Game instance and logic.
 */
public class GameController {
    private State state = new State();
    private final WindowInterface window;
    private final ControllerFactory factory;

    public GameController(WindowMode mode) throws Exception {
        window = WindowFactory.make(mode);
        factory = new ControllerFactory(mode);
        state.setStage(Stage.CHARACTER_CREATION);
    }

    /**
     * Starting main loop
     */
    public void start() throws Exception {
        window.launch();

        while (state.getStage() != Stage.QUIT) {
            val controller = factory.make(state.getStage());
            window.setController(controller);
            state = controller.update(state);
        }
    }

}
