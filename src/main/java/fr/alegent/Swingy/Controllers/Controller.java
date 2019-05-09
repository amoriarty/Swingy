package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;

public abstract class Controller {
    final GameController parent;
    final State state;
    final View view;

    Controller(ViewFactory factory,
               View.Type type,
               GameController parent,
               State state) throws Exception {
        this.view = factory != null ? factory.make(type) : null;
        this.parent = parent;
        this.state = state;

        if (view == null) return;
        view.setController(this);
    }

    void start() throws Exception {
        view.start();
    }

    public abstract String getTitle();
}
