package fr.alegent.Swingy.Models.Items.Armors;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class TheGondorsHorn extends Item {
    private final Type type = Type.ARMOR;
    private final String name = "The Gondor's Horn";
    private final String description = "Help comes every time you blow it. All you have to do is hope that the orcs don't get you first.";
    private final int healthBonus = -5;
    private final int attackBonus = 0;
    private final int armorBonus = 5;
    private final int luckBonus = 0;
}

