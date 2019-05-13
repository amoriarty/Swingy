package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;
import lombok.val;

public class FreeModeController extends Controller {

    public enum Action {
        MOVE, STATS, INVENTORY, QUIT
    }

    public FreeModeController(ViewFactory factory, GameController parent, State state) throws Exception {
        super(factory, View.Type.FREE, parent, state);
    }

    public String getTitle() {
        return "FREE MODE";
    }

    void start() throws Exception {
        val map = String.format("Current map %dx%d", state.map.size, state.map.size);
        val position = String.format(
                "Current position %dx%d",
                state.player.coordinate.x,
                state.player.coordinate.y
        );

        val formatted = String.format("%s\n%s", map, position);
        parent.view.println(formatted);
        super.start();
    }

    public void handle(Action action) {
        switch (action) {
            case MOVE:
                state.stage = State.Stage.MOVE;
                break;
            case STATS:
                state.stage = State.Stage.STATS;
                break;
            case INVENTORY:
                state.stage = State.Stage.INVENTORY;
                break;
            case QUIT:
                state.stage = State.Stage.QUIT;
                break;
        }

        parent.update(state);
    }
}
