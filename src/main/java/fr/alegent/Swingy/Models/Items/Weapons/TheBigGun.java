package fr.alegent.Swingy.Models.Items.Weapons;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class TheBigGun extends Item {
    private final Type type = Type.WEAPON;
    private final String name = "The Big Gun";
    private final String description = "";
    private final int healthBonus = 0;
    private final int attackBonus = 2;
    private final int armorBonus = 0;
    private final int luckBonus = 0;
}
