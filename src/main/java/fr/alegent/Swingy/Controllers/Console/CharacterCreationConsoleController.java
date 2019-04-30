package fr.alegent.Swingy.Controllers.Console;

import fr.alegent.Swingy.Interfaces.WindowControllerInterface;
import fr.alegent.Swingy.Models.Player;
import fr.alegent.Swingy.Models.State;
import lombok.Getter;
import lombok.val;

@Getter
public class CharacterCreationConsoleController extends ConsoleController implements WindowControllerInterface {
    final String title = "Character Creation";

    public State update(State state) {
        val name = getName();
        val origin = getOrigin();
        val player = new Player(name, origin);
        state.setPlayer(player);
        return state;
    }

    /**
     * Prompt user for his character name.
     * @return User defined character name.
     */
    private String getName() {
        System.out.println("Choose a name:");
        return getInput();
    }

    /**
     * Prompt user for his base origins.
     * @return User defined character origin.
     */
    private Player.Origin getOrigin() {
        System.out.println("Choose an origin:");
        for (int i = 0; i < Player.Origin.allCases.length; i++) {
            val name = Player.Origin.names[i];
            val description = Player.Origin.descriptions[i];
            val formatted = String.format("(%d) %s - %s", i, name, description);
            System.out.println(formatted);
        }

        try {
            val input = getInput();
            val index = Integer.parseInt(input);
            if (index < 0 || index > 8) {
                throw new Exception();
            }

            return Player.Origin.allCases[index];
        } catch (Exception exception) {
            System.err.println("Swingy: error: your input is invalid.");
            return getOrigin();
        }
    }
}
