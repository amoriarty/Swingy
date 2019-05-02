package fr.alegent.Swingy.Controllers.Console;

import fr.alegent.Swingy.Interfaces.ControllerInterface;
import fr.alegent.Swingy.Models.Player;
import fr.alegent.Swingy.Models.Stage;
import fr.alegent.Swingy.Models.State;
import lombok.Getter;
import lombok.val;

@Getter
public class CharacterCreationConsoleController extends ConsoleController implements ControllerInterface {
    final String title = "Character Creation";

    public State update(State state) {
        val name = prompt("Choose a name:");
        val origin = (Player.Origin) promptChoice("Choose an origin:", Player.Origin.allCases);
        val player = new Player();
        player.setName(name);
        player.setOrigin(origin);
        state.setPlayer(player);
        state.setMission(1);
        state.setStage(Stage.MISSION_GENERATION);
        return state;
    }

}
