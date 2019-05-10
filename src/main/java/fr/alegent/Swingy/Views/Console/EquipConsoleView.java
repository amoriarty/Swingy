package fr.alegent.Swingy.Views.Console;

import fr.alegent.Swingy.Controllers.EquipController;
import fr.alegent.Swingy.Models.Item;
import lombok.val;
import lombok.var;

public class EquipConsoleView extends ConsoleView {

    public void start() {
        val controller = (EquipController) this.controller;
        val list = controller.getItems();
        var items = new Item[list.size()];
        items = list.toArray(items);

        val item = choose(null, items);
        controller.equip(item);
    }

}
