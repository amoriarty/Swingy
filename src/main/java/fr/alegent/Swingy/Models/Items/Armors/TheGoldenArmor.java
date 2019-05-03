package fr.alegent.Swingy.Models.Items.Armors;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class TheGoldenArmor extends Item {
    private final Type type = Type.ARMOR;
    private final String name = "The Golden Armor";
    private final String description = "Possibility to dazzle enemies ... And passers-by ... and you too ... A little bit everyone actually !";
    private final int healthBonus = 2;
    private final int attackBonus = -2;
    private final int armorBonus = 5;
    private final int luckBonus = 0;
}

