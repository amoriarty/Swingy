package fr.alegent.Swingy.Models.Items.Weapons;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class TheShortSword extends Item {
    private final Type type = Type.WEAPON;
    private final String name = "The Short Sword";
    private final String description = "It's a short sword.";
    private final int healthBonus = 0;
    private final int attackBonus = 1;
    private final int armorBonus = 0;
    private final int luckBonus = 0;
}
