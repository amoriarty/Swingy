package fr.alegent.Swingy.Controllers.Console;

import fr.alegent.Swingy.Interfaces.ChoiceInterface;
import fr.alegent.Swingy.Interfaces.ControllerInterface;
import fr.alegent.Swingy.Models.Item;
import fr.alegent.Swingy.Models.Stage;
import fr.alegent.Swingy.Models.State;
import lombok.Getter;
import lombok.val;
import lombok.var;

@Getter
public class EquipConsoleController extends ConsoleController implements ControllerInterface {
    private final String title = "Equip";

    public State update(State state) {
        val player = state.getPlayer();
        val equipment = player.getEquipment();
        val inventory = player.getInventory();
        var choices = new ChoiceInterface[inventory.size()];
        choices = inventory.toArray(choices);

        val item = (Item) promptChoice(null, choices);
        inventory.remove(item);

        switch (item.getType()) {
            case HELM:
                val helm = equipment.getHelm();
                if (helm != null) inventory.add(helm);
                equipment.setHelm(item);
                break;
            case ARMOR:
                val armor = equipment.getArmor();
                if (armor != null) inventory.add(armor);
                equipment.setArmor(item);
                break;
            case WEAPON:
                val weapon = equipment.getWeapon();
                if (weapon != null) inventory.add(weapon);
                equipment.setWeapon(item);
                break;
        }

        player.setInventory(inventory);
        player.setEquipment(equipment);
        state.setStage(Stage.FREE);
        return state;
    }

}
