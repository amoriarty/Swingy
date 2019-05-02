package fr.alegent.Swingy.Controllers.Console;

import fr.alegent.Swingy.Interfaces.ControllerInterface;
import fr.alegent.Swingy.Models.Direction;
import fr.alegent.Swingy.Models.Stage;
import fr.alegent.Swingy.Models.State;
import lombok.Getter;
import lombok.val;

@Getter
public class MoveConsoleController extends ConsoleController implements ControllerInterface {
    private final String title = null;

    public State update(State state) {
        val direction = (Direction) promptChoice("Where to ?", Direction.allCases);
        val player = state.getPlayer();
        val coordinate = player.getCoordinate();

        switch (direction) {
            case NORTH:
                coordinate.goNorth();
                break;
            case EAST:
                coordinate.goEast();
                break;
            case WEST:
                coordinate.goWest();
                break;
            case SOUTH:
                coordinate.goSouth();
                break;
        }

        player.setCoordinate(coordinate);
        state.setPlayer(player);
        state.setStage(Stage.CHECK);
        return state;
    }

}
