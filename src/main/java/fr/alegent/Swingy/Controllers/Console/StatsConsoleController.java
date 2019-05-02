package fr.alegent.Swingy.Controllers.Console;

import fr.alegent.Swingy.Interfaces.ControllerInterface;
import fr.alegent.Swingy.Models.Equipment;
import fr.alegent.Swingy.Models.Item;
import fr.alegent.Swingy.Models.Stage;
import fr.alegent.Swingy.Models.State;
import lombok.Getter;
import lombok.val;

@Getter
public class StatsConsoleController extends ConsoleController implements ControllerInterface {
    private final String title = "Statistics";

    public State update(State state) {
        val player = state.getPlayer();
        val equipment = player.getEquipment();
        System.out.println(String.format("%s - %s", player.getName(), player.getOrigin().getName()));
        System.out.println(String.format("Health: %d / %d", player.getHealth(), player.getHealthMax()));
        System.out.println(String.format("Attack: %d", player.getAttack()));
        System.out.println(String.format("Armor: %d", player.getArmor()));
        System.out.println(String.format("Luck: %d", player.getLuck()));
        display(equipment.getHelm());
        display(equipment.getArmor());
        display(equipment.getWeapon());
        state.setStage(Stage.FREE);
        return state;
    }

    private void display(Item item) {
        if (item == null) return;

        val formatted = String.format("%s: %s (health: %d - attack: %d - armor %d - luck %d)",
                item.getType(),
                item.getName(),
                item.getHealthBonus(),
                item.getAttackBonus(),
                item.getArmorBonus(),
                item.getLuckBonus());
        System.out.println(formatted);
    }

}
