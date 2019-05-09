package fr.alegent.Swingy.Views;

import fr.alegent.Swingy.Controllers.Controller;

public interface View {
    enum Type {
        GAME,
        NEW_CHARACTER
    }

    void start() throws Exception;
    void setController(Controller controller);
}
