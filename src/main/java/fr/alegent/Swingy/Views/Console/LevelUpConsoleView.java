package fr.alegent.Swingy.Views.Console;

import fr.alegent.Swingy.Controllers.LevelUpController;
import lombok.val;

public class LevelUpConsoleView extends ConsoleView {

    public void start() {
        val type = choose(null, LevelUpController.Type.values());
        ((LevelUpController) controller).handle(type);
    }

}
