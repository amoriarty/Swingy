package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Interfaces.ControllerInterface;
import fr.alegent.Swingy.Models.Map;
import fr.alegent.Swingy.Models.State;
import lombok.Getter;
import lombok.val;

@Getter
public class MissionGenerationController implements ControllerInterface {
    final String title = "Mission Generation";

    public State update(State state) {
        val map = new Map(state.getMission());
        state.setMap(map);
        return state;
    }

}
