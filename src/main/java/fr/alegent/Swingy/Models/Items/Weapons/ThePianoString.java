package fr.alegent.Swingy.Models.Items.Weapons;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class ThePianoString extends Item {
    private final Type type = Type.WEAPON;
    private final String name = "The Piano String";
    private final String description = "For you, the music-loving warriors !";
    private final int healthBonus = 0;
    private final int attackBonus = 1;
    private final int armorBonus = 0;
    private final int luckBonus = 2;
}
