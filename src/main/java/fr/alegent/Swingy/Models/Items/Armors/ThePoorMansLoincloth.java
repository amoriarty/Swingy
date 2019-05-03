package fr.alegent.Swingy.Models.Items.Armors;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class ThePoorMansLoincloth extends Item {
    private final Type type = Type.ARMOR;
    private final String name = "The Poor Man's Loincloth";
    private final String description = "Well, you couldn't walk around naked, could you ?";
    private final int healthBonus = -1;
    private final int attackBonus = 0;
    private final int armorBonus = 0;
    private final int luckBonus = 0;
}

