package fr.alegent.Swingy.Models.Items.Helms;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class ThePlasticCrown extends Item {
    private final Type type = Type.HELM;
    private final String name = "The Plastic Crown";
    private final String description = "";
    private final int healthBonus = 3;
    private final int attackBonus = 0;
    private final int armorBonus = 1;
    private final int luckBonus = 1;
}
