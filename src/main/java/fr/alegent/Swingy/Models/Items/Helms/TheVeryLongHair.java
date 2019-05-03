package fr.alegent.Swingy.Models.Items.Helms;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class TheVeryLongHair extends Item {
    private final Type type = Type.HELM;
    private final String name = "The Very Long Hair";
    private final String description = "Can be very annoying in the wind.";
    private final int healthBonus = 0;
    private final int attackBonus = 0;
    private final int armorBonus = 0;
    private final int luckBonus = 0;
}
