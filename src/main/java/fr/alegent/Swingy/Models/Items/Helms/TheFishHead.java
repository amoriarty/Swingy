package fr.alegent.Swingy.Models.Items.Helms;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class TheFishHead extends Item {
    private final Type type = Type.HELM;
    private final String name = "The Fish Head";
    private final String description = "";
    private final int healthBonus = 5;
    private final int attackBonus = 0;
    private final int armorBonus = 2;
    private final int luckBonus = 0;
}
