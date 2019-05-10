package fr.alegent.Swingy.Controllers;

import fr.alegent.Swingy.Factories.ViewFactory;
import fr.alegent.Swingy.Models.Item;
import fr.alegent.Swingy.Models.State;
import fr.alegent.Swingy.Views.View;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

public class UnequipController extends Controller {

    public enum Action {
        UNEQUIP, RETURN
    }

    public UnequipController(ViewFactory factory, GameController parent, State state) throws Exception {
        super(factory, View.Type.UNEQUIP, parent, state);
    }

    public String getTitle() {
        return "UNEQUIP";
    }

    void start() throws Exception {
        if (!getItems().isEmpty()) {
            super.start();
            return;
        }

        state.stage = State.Stage.INVENTORY;
        parent.view.println("You have nothing equipped");
        parent.update(state);
    }

    public List<Item> getItems() {
        val equipment = state.player.equipment;
        val items = new ArrayList<Item>();
        if (equipment.helm != null) items.add(equipment.helm);
        if (equipment.armor != null) items.add(equipment.armor);
        if (equipment.weapon != null) items.add(equipment.weapon);
        return items;
    }

    @SuppressWarnings("ConstantConditions")
    public void unequip(Item item) {
        switch (item.type) {
            case HELM:
                state.player.equipment.helm = null;
                break;
            case ARMOR:
                state.player.equipment.armor = null;
                break;
            case WEAPON:
                state.player.equipment.weapon = null;
                break;
        }

        val formatted = String.format("You have unequipped %s", item.name);
        state.player.inventory.add(item);
        state.stage = State.Stage.INVENTORY;
        parent.view.println(formatted);
        parent.update(state);
    }

    public void previous() {
        state.stage = State.Stage.INVENTORY;
        parent.update(state);
    }
}
