package fr.alegent.Swingy.Models.Items.Helms;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class TheCloverHelmet extends Item {
    private final Type type = Type.HELM;
    private final String name = "The Clover Helmet";
    private final String description = "A regular helmet, decorated with a few four-leaf clovers.";
    private final int healthBonus = 2;
    private final int attackBonus = 0;
    private final int armorBonus = 0;
    private final int luckBonus = 3;
}
