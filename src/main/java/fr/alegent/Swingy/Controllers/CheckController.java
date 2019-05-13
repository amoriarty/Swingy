package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;
import lombok.val;

public class CheckController extends Controller {

    public CheckController(GameController parent, State state) throws Exception {
        super(null, View.Type.NONE, parent, state);
    }

    public String getTitle() {
        return null;
    }

    void start() {
        val coordinate = state.player.coordinate;
        val map = state.map;
        val item = map.items.get(coordinate);
        val enemy = map.enemies.get(coordinate);
        state.stage = State.Stage.FREE_MODE;

        if (coordinate.x < 0 || coordinate.y < 0 || coordinate.x > map.size || coordinate.y > map.size) {
            state.stage = State.Stage.MISSION_GENERATION;
            parent.view.println("MISSION PASSED");
        }

        if (item != null) {
            //noinspection ConstantConditions
            parent.view.println("You have loot " + item.name);
            state.player.inventory.add(item);
            state.map.items.remove(coordinate);
        }

        if (enemy != null) {
            state.stage = State.Stage.FIGHT;
            state.enemy = enemy;
        }

        parent.update(state);
    }

}
