package fr.alegent.Swingy.Controllers.Console;

import fr.alegent.Swingy.Interfaces.WindowControllerInterface;
import fr.alegent.Swingy.Models.State;
import lombok.Getter;
import lombok.val;

@Getter
public class CharacterCreationConsoleController extends ConsoleController implements WindowControllerInterface {
    final String title = "Character Creation";

    public State update(State state) {
        System.out.println("Name:");
        val characterName = getInput();

        System.out.println("Class:");
        val characterClass = getInput();

        System.out.println(characterName + ' ' + characterClass);

        return state;
    }
}
