package fr.alegent.Swingy.Views.Console;

import fr.alegent.Swingy.Controllers.LoadCharacterController;
import lombok.val;

public class LoadCharacterConsoleView extends ConsoleView {

    public void start() {
        val controller = (LoadCharacterController) this.controller;
        val saves = controller.getSaves();
        val save = choose(null, saves);
        controller.load(save.player);
    }

}
