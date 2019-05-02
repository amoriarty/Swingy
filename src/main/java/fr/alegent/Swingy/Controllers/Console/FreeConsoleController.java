package fr.alegent.Swingy.Controllers.Console;

import fr.alegent.Swingy.Interfaces.ControllerInterface;
import fr.alegent.Swingy.Models.FreeModeActions;
import fr.alegent.Swingy.Models.Stage;
import fr.alegent.Swingy.Models.State;
import lombok.Getter;
import lombok.val;

@Getter
public class FreeConsoleController extends ConsoleController implements ControllerInterface {
    final String title = null;

    public State update(State state) {
        val player = state.getPlayer();
        val map = state.getMap();
        val size = map.getSize();
        System.out.println(String.format("Current mission %d", state.getMission()));
        System.out.println(String.format("Current map %dx%d", size, size));
        System.out.println("Current position " + player.getCoordinate());

        val action = (FreeModeActions) promptChoice(null, FreeModeActions.allCases);
        switch (action) {
            case MOVE:
                state.setStage(Stage.MOVE);
                break;
            case QUIT:
                state.setStage(Stage.QUIT);
                break;
        }

        return state;
    }

}
