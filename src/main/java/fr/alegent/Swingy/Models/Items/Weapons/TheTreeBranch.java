package fr.alegent.Swingy.Models.Items.Weapons;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class TheTreeBranch extends Item {
    private final Type type = Type.WEAPON;
    private final String name = "The Tree Branch";
    private final String description = "Found on the side of the road, in the dark and with your eyes closed, she looks vaguely like a real sword.";
    private final int healthBonus = 0;
    private final int attackBonus = 1;
    private final int armorBonus = 0;
    private final int luckBonus = 0;
}
