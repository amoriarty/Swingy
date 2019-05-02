package fr.alegent.Swingy.Controllers.Console;

import fr.alegent.Swingy.Interfaces.ControllerInterface;
import fr.alegent.Swingy.Models.Actions.InventoryModeActions;
import fr.alegent.Swingy.Models.Stage;
import fr.alegent.Swingy.Models.State;
import lombok.Getter;
import lombok.val;

@Getter
public class InventoryConsoleController extends ConsoleController implements ControllerInterface {
    private final String title = "Inventory";

    public State update(State state) {
        val action = (InventoryModeActions) promptChoice(null, InventoryModeActions.allCases);
        val inventory = state.getPlayer().getInventory();

        switch (action) {
            case EQUIP:
                if (inventory.size() == 0) {
                    System.out.println("No item to equip.");
                    break;
                }
                state.setStage(Stage.EQUIP);
                break;
            case RETURN:
                state.setStage(Stage.FREE);
                break;
        }

        return state;
    }

}
