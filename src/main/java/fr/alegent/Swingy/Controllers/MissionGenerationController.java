package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Models.Coordinate;
import fr.alegent.Swingy.Models.Map;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;

public class MissionGenerationController extends Controller {

    public MissionGenerationController(GameController parent, State state) throws Exception {
        super(null, View.Type.NONE, parent, state);
    }

    public String getTitle() {
        return null;
    }

    void start() throws Exception {
        state.mission += 1;
        state.map = new Map(state.mission);
        state.coordinate = new Coordinate(state.map.size / 2, state.map.size / 2);
        state.player.coordinate = new Coordinate(state.coordinate);
        state.stage = State.Stage.FREE_MODE;
        parent.update(state);
    }

}
