package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.Player;
import fr.alegent.Swingy.Models.Save;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;

public class LoadCharacterController extends Controller {

    public LoadCharacterController(ViewFactory factory, GameController parent, State state) throws Exception {
        super(factory, View.Type.LOAD_CHARACTER, parent, state);
    }

    public String getTitle() {
        return "LOAD GAME";
    }

    public Save[] getSaves() {
        return state.saves;
    }

    public void load(Player player) {
        state.player = player;
        state.stage = State.Stage.MISSION_GENERATION;
        parent.update(state);
    }

}
