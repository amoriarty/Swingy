package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;
import lombok.val;

public class StatsController extends Controller {

    public StatsController(GameController parent, State state) throws Exception {
        super(null, View.Type.NONE, parent, state);
    }

    public String getTitle() {
        return "Character Statistics";
    }

    void start() {
        val player = state.player;
        val equipment = player.equipment;
        val name = String.format("Name: %s", player.name);
        //noinspection ConstantConditions
        val origin = String.format("Origin: %s - %s", player.origin.name, player.origin.description);
        val health = String.format("Health: %d / %d", player.getHealth(), player.getMaxHP());
        val attack = String.format("Attack: %d", player.getAttack());
        val armor = String.format("Armor: %d", player.getArmor());
        val luck = String.format("Luck: %d", player.getLuck());
        val items = String.format(
                "Helm: %s\nArmor: %s\nWeapon: %s",
                equipment.helm != null ? equipment.helm.toString() : "none",
                equipment.armor != null ? equipment.armor.toString() : "none",
                equipment.weapon != null ? equipment.weapon.toString() : "none"
        );

        val formatted = String.format(
                "%s\n%s\n%s\n%s\n%s\n%s\n%s",
                name,
                origin,
                health,
                attack,
                armor,
                luck,
                items
        );

        state.stage = State.Stage.FREE_MODE;
        parent.view.println(formatted);
        parent.update(state);
    }

}
