package fr.alegent.Swingy.Factories;

import fr.alegent.Swingy.Controllers.Console.CharacterCreationConsoleController;
import fr.alegent.Swingy.Controllers.Console.FreeConsoleController;
import fr.alegent.Swingy.Controllers.MissionGenerationController;
import fr.alegent.Swingy.Interfaces.ControllerInterface;
import fr.alegent.Swingy.Models.Stage;
import fr.alegent.Swingy.Models.WindowMode;
import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class ControllerFactory {
    private final WindowMode mode;

    private final Map<Stage, Class<? extends ControllerInterface>> console = new HashMap<Stage, Class<? extends ControllerInterface>>() {{
        put(Stage.CHARACTER_CREATION, CharacterCreationConsoleController.class);
        put(Stage.FREE, FreeConsoleController.class);
        put(Stage.MISSION_GENERATION, MissionGenerationController.class);
    }};

    private final Map<Stage, Class<? extends ControllerInterface>> gui = new HashMap<Stage, Class<? extends ControllerInterface>>() {{
        put(Stage.MISSION_GENERATION, MissionGenerationController.class);
    }};

    /**
     * Instantiate correct controller based on game stage.
     * @param stage Current game stage
     * @return Controller able to update state of from a game stage.
     */
    public ControllerInterface make(Stage stage) throws Exception {
        val map = mode == WindowMode.CONSOLE ? console : gui;
        val controller = map.get(stage);
        return controller.getDeclaredConstructor().newInstance();
    }

}
