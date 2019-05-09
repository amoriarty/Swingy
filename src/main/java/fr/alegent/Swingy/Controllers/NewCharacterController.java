package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.Origin;
import fr.alegent.Swingy.Models.Player;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;

public class NewCharacterController extends Controller {

    NewCharacterController(ViewFactory factory, GameController parent, State state) throws Exception {
        super(factory, View.Type.NEW_CHARACTER, parent, state);
    }

    public void create(String name, Origin origin) {
        if (name == null || origin == null) return;
        if (name.isEmpty()) {
            parent.view.println("Character name can't be empty.");
            return;
        }

        state.player = new Player(name, origin);
        parent.update(state);
    }

}
