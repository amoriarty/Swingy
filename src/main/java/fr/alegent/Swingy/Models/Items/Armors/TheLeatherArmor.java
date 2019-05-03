package fr.alegent.Swingy.Models.Items.Armors;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class TheLeatherArmor extends Item {
    private final Type type = Type.ARMOR;
    private final String name = "The Leather Armor";
    private final String description = "Made of top quality snail leather ! (May possibly smell bad in case of high heat)";
    private final int healthBonus = 0;
    private final int attackBonus = -1;
    private final int armorBonus = 2;
    private final int luckBonus = 0;
}
