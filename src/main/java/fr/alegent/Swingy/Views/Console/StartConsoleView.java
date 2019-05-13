package fr.alegent.Swingy.Views.Console;

import fr.alegent.Swingy.Controllers.StartController;
import lombok.val;

public class StartConsoleView extends ConsoleView {

    public void start() {
        val action = choose(null, StartController.Action.values());
        ((StartController) controller).handle(action);
    }

}
