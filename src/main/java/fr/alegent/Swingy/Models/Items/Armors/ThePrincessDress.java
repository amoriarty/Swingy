package fr.alegent.Swingy.Models.Items.Armors;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class ThePrincessDress extends Item {
    private final Type type = Type.ARMOR;
    private final String name = "The Princess Dress";
    private final String description = "Because princesses also have the right to be badass.";
    private final int healthBonus = 0;
    private final int attackBonus = 0;
    private final int armorBonus = 2;
    private final int luckBonus = -1;
}
