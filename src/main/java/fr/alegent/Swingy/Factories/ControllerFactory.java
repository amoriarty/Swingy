package fr.alegent.Swingy.Factories;

import fr.alegent.Swingy.Controllers.Controller;
import fr.alegent.Swingy.Controllers.GameController;
import fr.alegent.Swingy.Controllers.NewCharacterController;
import fr.alegent.Swingy.Exceptions.NoControllerDefined;
import fr.alegent.Swingy.Models.State;

public class ControllerFactory {

    public static Controller make(State.Stage stage,
                                  ViewFactory factory,
                                  GameController parent,
                                  State state) throws Exception {
        switch (stage) {
            case NEW_CHARACTER: return new NewCharacterController(factory, parent, state);
            default: throw new NoControllerDefined(stage);
        }
    }

}
