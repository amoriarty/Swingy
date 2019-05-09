package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Exceptions.InvalidGameMode;
import fr.alegent.Swingy.Factories.ControllerFactory;
import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.State;
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
            state.stage = State.Stage.NEW_CHARACTER;
        } catch (IllegalArgumentException exception) {
            throw new InvalidGameMode();
        }
    }

    public void start() throws Exception {
        while (state.stage != State.Stage.QUIT) {
            if (!changes) continue;
            changes = false;

            val controller = ControllerFactory.make(state.stage, factory, this, state);
            view.addSubview(controller.view);
            view.println(controller.getTitle());
            controller.start();
        }
    }

    void update(State state) {
        this.state = state;
        this.changes = true;
        view.println(state.player.name + " " + state.player.origin);
        view.println("===========================================");
    }

}
