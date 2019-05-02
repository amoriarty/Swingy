package fr.alegent.Swingy.Controllers.Console;

import fr.alegent.Swingy.Interfaces.ControllerInterface;
import fr.alegent.Swingy.Models.State;
import lombok.Getter;

@Getter
public class FreeConsoleController extends ConsoleController implements ControllerInterface {
    final String title = "Free Mode";

    public State update(State state) {
        return state;
    }

}
