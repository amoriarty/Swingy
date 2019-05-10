package fr.alegent.Swingy.Views.Console;

import fr.alegent.Swingy.Controllers.FreeModeController;
import lombok.val;

public class FreeModeConsoleView extends ConsoleView {

    public void start() {
        val action = choose(null, FreeModeController.Action.values());
        ((FreeModeController) controller).handle(action);
    }

}
