package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Interfaces.ControllerInterface;
import fr.alegent.Swingy.Models.Stage;
import fr.alegent.Swingy.Models.State;
import lombok.Getter;
import lombok.val;

@Getter
public class CheckController implements ControllerInterface {
    private final String title = null;

    public State update(State state) {
        val map = state.getMap();
        val size = map.getSize();
        val player = state.getPlayer();
        val coordinates = player.getCoordinate();
        val items = map.getItems();
        val item = items.get(coordinates);
        state.setStage(Stage.FREE);

        if (coordinates.getX() < 0
                || coordinates.getX() > size
                || coordinates.getY() < 0
                || coordinates.getY() > size) {
            System.out.println("MISSION PASSED");
            state.setMission(state.getMission() + 1);
            state.setStage(Stage.MISSION_GENERATION);
            return state;
        }

        if (item != null) {
            val formatted = String.format("You loot %s - %s", item.getName(), item.getDescription());
            val inventory = player.getInventory();
            System.out.println(formatted);
            inventory.add(item);
            player.setInventory(inventory);
            items.remove(coordinates);
            map.setItems(items);
            state.setMap(map);
            state.setPlayer(player);
        }

        return state;
    }

}
