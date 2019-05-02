package fr.alegent.Swingy.Models.Items.Weapons;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class TheGoldenSword extends Item {
    private final Type type = Type.WEAPON;
    private final String name = "The Golden Sword";
    private final String description = "";
    private final int healthBonus = 0;
    private final int attackBonus = 5;
    private final int armorBonus = 0;
    private final int luckBonus = 0;
}
