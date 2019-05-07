package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Exceptions.InvalidGameMode;
import fr.alegent.Swingy.Services.EnemiesService;
import fr.alegent.Swingy.Services.ItemsService;
import fr.alegent.Swingy.Services.OriginsService;
import lombok.val;

public class GameController {
    private final Mode mode;

    enum Mode {
        CONSOLE, GUI
    }

    public GameController(String mode) throws Exception {
        try { this.mode = Mode.valueOf(mode); }
        catch (Exception exception) { throw new InvalidGameMode(); }
    }

    public void start() {
        val items = ItemsService.shared.elements;
        val enemies = EnemiesService.shared.elements;
        val origins = OriginsService.shared.elements;

        for (val item: items) {
            System.out.println(item);
        }

        for (val enemy: enemies) {
            System.out.println(enemy);
        }

        for (val origin: origins) {
            System.out.println(origin);
        }
    }
}
