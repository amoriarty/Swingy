package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Views.Generics.NewCharacterView;
import fr.alegent.Swingy.Views.View;

class NewCharacterController {
    private final GameController parent;
    final NewCharacterView view;

    public NewCharacterController(ViewFactory factory, GameController parent) throws Exception {
        view = factory.make(View.Type.NEW_CHARACTER);
        this.parent = parent;
    }

    void start() {
        parent.view.println("Starting new character controller.");
    }

}
