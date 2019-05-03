package fr.alegent.Swingy.Models.Items.Armors;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class TheSuit extends Item {
    private final Type type = Type.ARMOR;
    private final String name = "The Suit";
    private final String description = "Of course there's a suit ! And custom-made too !";
    private final int healthBonus = 0;
    private final int attackBonus = 0;
    private final int armorBonus = 1;
    private final int luckBonus = 0;
}

