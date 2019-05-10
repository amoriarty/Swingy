package fr.alegent.Swingy.Views.Console;

import fr.alegent.Swingy.Controllers.MoveController;
import lombok.val;

public class MoveConsoleView extends ConsoleView {

    public void start() {
        val direction = choose(null, MoveController.Direction.values());
        ((MoveController) controller).handle(direction);
    }

}
