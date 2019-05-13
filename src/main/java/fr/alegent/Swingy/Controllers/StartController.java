package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;

public class StartController extends Controller {

    public enum Action {
        NEW_GAME, LOAD_GAME;

        public String toString() {
            switch (this) {
                case NEW_GAME: return "NEW GAME";
                case LOAD_GAME: return "LOAD GAME";
            }
            return null;
        }
    }

    public StartController(ViewFactory factory, GameController parent, State state) throws Exception {
        super(factory, View.Type.START, parent, state);
    }

    public String getTitle() {
        return "SWINGY";
    }

    public void handle(Action action) {
        switch (action) {
            case NEW_GAME:
                state.stage = State.Stage.NEW_CHARACTER;
                break;
            case LOAD_GAME:
                state.stage = State.Stage.LOAD_CHARACTER;
                break;
        }

        parent.update(state);
    }

}
