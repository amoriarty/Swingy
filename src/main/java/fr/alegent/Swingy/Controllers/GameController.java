package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Exceptions.InvalidGameMode;
import fr.alegent.Swingy.Factories.ControllerFactory;
import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Services.SavesServices;
import fr.alegent.Swingy.Views.GameView;
import fr.alegent.Swingy.Views.View;
import lombok.val;

public class GameController {
    private final ViewFactory factory;
    private boolean changes = true;
    private State state = new State();
    final GameView view;

    public GameController(String mode) throws Exception {
        try {
            factory = new ViewFactory(mode);
            view = factory.make(View.Type.GAME);
            state.stage = state.saves.length == 0
                    ? State.Stage.NEW_CHARACTER
                    : State.Stage.START;
        } catch (IllegalArgumentException exception) {
            throw new InvalidGameMode();
        }
    }

    public void start() throws Exception {
        while (state.stage != State.Stage.QUIT) {
            if (!changes) continue;
            SavesServices.save(state.player);
            changes = false;

            val controller = ControllerFactory.make(state.stage, factory, this, state);
            val title = controller.getTitle();
            if (title != null) view.println(title);
            view.addSubview(controller.view);
            controller.start();
        }

        view.dispose();
    }

    void update(State state) {
        this.state = state;
        this.changes = true;
        view.println("-------------------------------------------");
    }

}
