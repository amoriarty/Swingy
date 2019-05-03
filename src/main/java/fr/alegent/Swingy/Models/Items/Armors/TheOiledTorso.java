package fr.alegent.Swingy.Models.Items.Armors;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class TheOiledTorso extends Item {
    private final Type type = Type.ARMOR;
    private final String name = "The Oiled Torso";
    private final String description = "Because you never know, you might as well look cool ...";
    private final int healthBonus = 0;
    private final int attackBonus = 0;
    private final int armorBonus = 0;
    private final int luckBonus = 0;
}
