package fr.alegent.Swingy.Controllers.Console;

import fr.alegent.Swingy.Interfaces.ChoiceInterface;
import fr.alegent.Swingy.Interfaces.ControllerInterface;
import fr.alegent.Swingy.Models.Item;
import fr.alegent.Swingy.Models.Stage;
import fr.alegent.Swingy.Models.State;
import lombok.Getter;
import lombok.val;
import lombok.var;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UnequippedConsoleController extends ConsoleController implements ControllerInterface {
    private final String title = "Unequipped";

    public State update(State state) {
        val player = state.getPlayer();
        val equipment = player.getEquipment();
        val inventory = player.getInventory();
        val items = new ArrayList<Item>();
        val helm = equipment.getHelm();
        val armor = equipment.getArmor();
        val weapon = equipment.getWeapon();

        if (helm != null) items.add(helm);
        if (armor != null) items.add(armor);
        if (weapon != null) items.add(weapon);

        var choices = new ChoiceInterface[items.size()];
        choices = items.toArray(choices);

        val item = (Item) promptChoice(null, choices);
        inventory.add(item);
        player.setInventory(inventory);

        switch (item.getType()) {
            case HELM:
                equipment.setHelm(null);
                break;
            case ARMOR:
                equipment.setArmor(null);
                break;
            case WEAPON:
                equipment.setWeapon(null);
                break;
        }

        player.setEquipment(equipment);
        state.setPlayer(player);
        state.setStage(Stage.FREE);
        return state;
    }

}
