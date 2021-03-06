package fr.alegent.Swingy.Views;

import fr.alegent.Swingy.Controllers.Controller;

public interface View {
    enum Type {
        NONE, GAME, START, NEW_CHARACTER, LOAD_CHARACTER,
        FREE, MOVE, INVENTORY, EQUIP, UNEQUIP, FIGHT, LEVEL_UP
    }

    void start() throws Exception;
    void setController(Controller controller);
}
