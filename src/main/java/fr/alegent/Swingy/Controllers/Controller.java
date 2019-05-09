package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;

public abstract class Controller {
    final String title = null;
    final GameController parent;
    final State state;
    final View view;

    Controller(ViewFactory factory,
               View.Type type,
               GameController parent,
               State state) throws Exception {
        this.view = factory.make(type);
        this.view.setController(this);
        this.parent = parent;
        this.state = state;
    }

    void start() throws Exception {
        view.start();
    }
}
