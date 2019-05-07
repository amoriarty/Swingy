package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Exceptions.InvalidGameMode;
import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.Enemy;
import fr.alegent.Swingy.Models.Item;
import fr.alegent.Swingy.Models.Origin;
import fr.alegent.Swingy.Services.ResourceService;
import fr.alegent.Swingy.Views.GameView;
import fr.alegent.Swingy.Views.View;
import lombok.val;

public class GameController {
    private final GameView view;
    private final Item[] items;
    private final Origin[] origins;
    private final Enemy[] enemies;

    public GameController(String mode) throws Exception {
        try {
            val factory = new ViewFactory(mode);
            view = (GameView) factory.make(View.Type.GAME);
            items = ResourceService.shared.get("items.json", Item[].class);
            origins = ResourceService.shared.get("origins.json", Origin[].class);
            enemies = ResourceService.shared.get("enemies.json", Enemy[].class);
        } catch (IllegalArgumentException exception) {
            throw new InvalidGameMode();
        }
    }

    public void start() {
        for (val item: items) {
            view.println(item.toString());
        }

        for (val enemy: enemies) {
            view.println(enemy.toString());
        }

        for (val origin: origins) {
            view.println(origin.toString());
        }
    }

}
