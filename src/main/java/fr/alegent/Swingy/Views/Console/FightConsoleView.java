package fr.alegent.Swingy.Views.Console;

import fr.alegent.Swingy.Controllers.FightController;
import lombok.val;

public class FightConsoleView extends ConsoleView {

    public void start() {
        val action = choose(null, FightController.Action.values());
        ((FightController) controller).handle(action);
    }

}
