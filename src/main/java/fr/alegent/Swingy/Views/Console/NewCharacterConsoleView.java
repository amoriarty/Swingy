package fr.alegent.Swingy.Views.Console;

import fr.alegent.Swingy.Controllers.NewCharacterController;
import fr.alegent.Swingy.Models.Origin;
import fr.alegent.Swingy.Services.ResourcesService;
import lombok.val;

public class NewCharacterConsoleView extends ConsoleView {

    public void start() throws Exception {
        val origins = ResourcesService.shared.get("origins.json", Origin[].class);
        val name = prompt("Name:");
        val origin = choose("Origin:", origins);
        ((NewCharacterController) controller).create(name, origin);
    }

}
