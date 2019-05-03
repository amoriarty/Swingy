package fr.alegent.Swingy.Models.Items.Armors;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class ThePinkShort extends Item {
    private final Type type = Type.ARMOR;
    private final String name = "The Pink Short";
    private final String description = "I like this color, it looks good on you !";
    private final int healthBonus = 0;
    private final int attackBonus = 0;
    private final int armorBonus = 0;
    private final int luckBonus = 0;
}

