package fr.alegent.Swingy.Models.Items.Armors;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class TheHawaiianShort extends Item {
    private final Type type = Type.ARMOR;
    private final String name = "The Hawaiian Short";
    private final String description = "You can't be good at everything ...";
    private final int healthBonus = 0;
    private final int attackBonus = 0;
    private final int armorBonus = 0;
    private final int luckBonus = -1;
}
