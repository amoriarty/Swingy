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
    final GameView view;

    public GameController(String mode) throws Exception {
        try {
            factory = new ViewFactory(mode);
            view = factory.make(View.Type.GAME);
        } catch (IllegalArgumentException exception) {
            throw new InvalidGameMode();
        }
    }

    public void start() throws Exception {
        val state = new State();
        state.stage = state.saves.length == 0
                ? State.Stage.NEW_CHARACTER
                : State.Stage.START;
        update(state);
    }

    void update(State state) {
        view.println("-------------------------------------------");

        try {
            SavesServices.save(state.player);

            if (state.stage == State.Stage.QUIT) {
                view.dispose();
                return;
            }

            val controller = ControllerFactory.make(state.stage, factory, this, state);
            val title = controller.getTitle();
            if (title != null) view.println(title);
            view.addSubview(controller.view);
            controller.start();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
