package fr.alegent.Swingy.Models.Items.Helms;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class TheRedBandanna extends Item {
    private final Type type = Type.HELM;
    private final String name = "The Red Bandanna";
    private final String description = "";
    private final int healthBonus = 0;
    private final int attackBonus = 0;
    private final int armorBonus = 0;
    private final int luckBonus = 0;
}

