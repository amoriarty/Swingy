package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Exceptions.InvalidGameMode;
import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.Generics.GameView;
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
        state.stage = State.Stage.NEW_CHARACTER;
        update(state);
    }

    private void update(State state) throws Exception {
        val controller = new NewCharacterController(factory, this);
        view.addSubview(controller.view);
        controller.start();
    }

}
