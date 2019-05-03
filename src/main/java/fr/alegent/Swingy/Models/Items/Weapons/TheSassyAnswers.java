package fr.alegent.Swingy.Models.Items.Weapons;

import fr.alegent.Swingy.Models.Item;
import lombok.Getter;

@Getter
public class TheSassyAnswers extends Item {
    private final Type type = Type.WEAPON;
    private final String name = "The Sassy Answers";
    private final String description = "Not everyone necessarily understands sarcasm, but it's still dassy";
    private final int healthBonus = 1;
    private final int attackBonus = 5;
    private final int armorBonus = 5;
    private final int luckBonus = -2;
}
