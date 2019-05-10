package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.Origin;
import fr.alegent.Swingy.Models.Player;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;

public class NewCharacterController extends Controller {

    public NewCharacterController(ViewFactory factory, GameController parent, State state) throws Exception {
        super(factory, View.Type.NEW_CHARACTER, parent, state);
    }

    public String getTitle() {
        return "NEW CHARACTER";
    }

    public void create(String name, Origin origin) {
        if (name == null || origin == null) return;
        if (name.isEmpty()) {
            parent.view.println("Character name can't be empty.");
            return;
        }

        state.player = new Player(name, origin);
        state.stage = State.Stage.MISSION_GENERATION;
        parent.update(state);
    }

}
