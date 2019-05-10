package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;

public class MoveController extends Controller {

    public enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    public MoveController(ViewFactory factory, GameController parent, State state) throws Exception {
        super(factory, View.Type.MOVE, parent, state);
    }

    public String getTitle() {
        return "Where to ?";
    }

    public void handle(Direction direction) {
        switch (direction) {
            case NORTH:
                state.player.coordinate.y -= 1;
                break;
            case SOUTH:
                state.player.coordinate.y += 1;
                break;
            case EAST:
                state.player.coordinate.x -= 1;
                break;
            case WEST:
                state.player.coordinate.x += 1;
                break;
        }

        state.stage = State.Stage.FREE_MODE;
        parent.update(state);
    }

}
