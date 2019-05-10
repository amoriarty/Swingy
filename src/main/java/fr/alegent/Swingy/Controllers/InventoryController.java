package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;
import lombok.val;

public class InventoryController extends Controller {
    
    public enum Action {
        EQUIP, UNEQUIP, RETURN
    }

    public InventoryController(ViewFactory factory, GameController parent, State state) throws Exception {
        super(factory, View.Type.INVENTORY, parent, state);
    }

    public String getTitle() {
        return "Inventory";
    }

    void start() throws Exception {
        super.start();
        for (val item: state.player.inventory) {
            parent.view.println(item.toString());
        }
    }

    public void handle(Action action) {
        switch (action) {
            case EQUIP:
                state.stage = State.Stage.EQUIP;
                break;
            case UNEQUIP:
                state.stage = State.Stage.UNEQUIP;
                break;
            case RETURN:
                state.stage = State.Stage.FREE_MODE;
                break;
        }

        parent.update(state);
    }

}
