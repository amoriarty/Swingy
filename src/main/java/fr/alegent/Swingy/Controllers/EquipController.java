package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.Item;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;
import lombok.val;

import java.util.List;

public class EquipController extends Controller {

    public enum Action {
        EQUIP, RETURN
    }

    public EquipController(ViewFactory factory, GameController parent, State state) throws Exception {
        super(factory, View.Type.EQUIP, parent, state);
    }

    public String getTitle() {
        return "EQUIP";
    }

    void start() throws Exception {
        super.start();
        if (!state.player.inventory.isEmpty()) return;
        state.stage = State.Stage.INVENTORY;
        parent.view.println("You inventory is empty.");
        parent.update(state);
    }

    public List<Item> getItems() {
        return state.player.inventory;
    }

    @SuppressWarnings("ConstantConditions")
    public void equip(Item item) {
        val current = state.player.equipment.getItem(item.type);
        val formatted = String.format("You have equip %s", item.name);

        state.player.equipment.set(item);
        state.player.inventory.remove(item);

        if (current != null) state.player.inventory.add(current);
        state.stage = State.Stage.FREE_MODE;
        parent.view.println(formatted);
        parent.update(state);
    }

    public void previous() {
        state.stage = State.Stage.INVENTORY;
        parent.update(state);
    }

}
