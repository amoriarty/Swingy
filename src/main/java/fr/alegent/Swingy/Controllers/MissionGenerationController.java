package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Interfaces.ControllerInterface;
import fr.alegent.Swingy.Models.Coordinate;
import fr.alegent.Swingy.Models.Map;
import fr.alegent.Swingy.Models.Stage;
import fr.alegent.Swingy.Models.State;
import lombok.Getter;
import lombok.val;

@Getter
public class MissionGenerationController implements ControllerInterface {
    final String title = null;

    public State update(State state) throws Exception {
        val map = new Map(state.getMission());
        val size = map.getSize();
        val coordinate = new Coordinate(size / 2, size / 2);
        val player = state.getPlayer();
        player.setCoordinate(coordinate);
        state.setPlayer(player);
        state.setMap(map);
        state.setStage(Stage.FREE);
        return state;
    }

}
