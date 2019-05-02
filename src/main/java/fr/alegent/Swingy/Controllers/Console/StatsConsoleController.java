package fr.alegent.Swingy.Controllers.Console;

import fr.alegent.Swingy.Interfaces.ControllerInterface;
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
        val helm = equipment.getHelm();
        val armor = equipment.getArmor();
        val weapon = equipment.getWeapon();
        System.out.println(String.format("%s - %s", player.getName(), player.getOrigin().getName()));
        System.out.println(String.format("Health: %d / %d", player.getHealth(), player.getHealthMax()));
        System.out.println(String.format("Attack: %d", player.getAttack()));
        System.out.println(String.format("Armor: %d", player.getArmor()));
        System.out.println(String.format("Luck: %d", player.getLuck()));
        if (helm != null) System.out.println(helm);
        if (armor != null) System.out.println(armor);
        if (weapon != null) System.out.println(weapon);
        state.setStage(Stage.FREE);
        return state;
    }

}
