package fr.alegent.Swingy.Services;

import fr.alegent.Swingy.Models.Item;

public class ItemsService extends ResourceService<Item> {
    public static final ItemsService shared = new ItemsService();

    private ItemsService() {
        super("items.json", Item[].class);
    }
}
