package fr.alegent.Swingy.Views.Console;

import fr.alegent.Swingy.Controllers.UnequipController;
import fr.alegent.Swingy.Models.Item;
import lombok.val;
import lombok.var;

public class UnequipConsoleView extends ConsoleView {

    public void start() {
        val controller = (UnequipController) this.controller;
        val list = controller.getItems();
        var items = new Item[list.size()];
        items = list.toArray(items);

        val item = choose(null, items);
        controller.unequip(item);
    }

}
