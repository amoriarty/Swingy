package fr.alegent.Swingy.Views.Console;

import fr.alegent.Swingy.Controllers.InventoryController;
import lombok.val;

public class InventoryConsoleView extends ConsoleView {

    public void start() {
        val action = choose(null, InventoryController.Action.values());
        ((InventoryController) controller).handle(action);
    }

}
