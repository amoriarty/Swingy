package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.Coordinate;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;

public class MoveController extends Controller {

    public enum Direction {
        NORTH, SOUTH, EAST, WEST, RETURN
    }

    public MoveController(ViewFactory factory, GameController parent, State state) throws Exception {
        super(factory, View.Type.MOVE, parent, state);
    }

    public String getTitle() {
        return null;
    }

    void start() throws Exception {
        super.start();
        parent.view.println("Where to ?");
    }

    public void handle(Direction direction) {
        state.coordinate = new Coordinate(state.player.coordinate);

        switch (direction) {
            case NORTH:
                state.player.coordinate.y -= 1;
                parent.view.println("You moved north.");
                break;
            case SOUTH:
                state.player.coordinate.y += 1;
                parent.view.println("You moved south.");
                break;
            case EAST:
                state.player.coordinate.x -= 1;
                parent.view.println("You moved east.");
                break;
            case WEST:
                state.player.coordinate.x += 1;
                parent.view.println("You moved west.");
                break;
            case RETURN:
                parent.view.println("You didn't move.");
                break;
        }

        state.stage = State.Stage.CHECK;
        parent.update(state);
    }

}
