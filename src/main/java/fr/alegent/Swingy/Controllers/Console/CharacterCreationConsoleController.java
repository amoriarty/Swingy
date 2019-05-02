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
        val name = promptName();
        val origin = promptOrigin();
        val player = new Player();
        player.setName(name);
        player.setOrigin(origin);
        state.setPlayer(player);
        state.setMission(1);
        state.setStage(Stage.MISSION_GENERATION);
        return state;
    }

    /**
     * Prompt user for his character name.
     * @return User defined character name.
     */
    private String promptName() {
        System.out.println("Choose a name:");
        return prompt();
    }

    /**
     * Prompt user for his base origins.
     * @return User defined character origin.
     */
    private Player.Origin promptOrigin() {
        System.out.println("Choose an origin:");
        for (int i = 0; i < Player.Origin.allCases.length; i++) {
            val origin = Player.Origin.allCases[i];
            val name = origin.getName();
            val description = origin.getDescription();
            val formatted = String.format("(%d) %s - %s", i, name, description);
            System.out.println(formatted);
        }

        try {
            val input = prompt();
            val index = Integer.parseInt(input);
            if (index < 0 || index > Player.Origin.allCases.length) {
                throw new Exception();
            }

            return Player.Origin.allCases[index];
        } catch (Exception exception) {
            System.err.println("Swingy: error: your input is invalid.");
            return promptOrigin();
        }
    }
}
