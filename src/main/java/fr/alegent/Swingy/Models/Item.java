package fr.alegent.Swingy.Models;

import fr.alegent.Swingy.Interfaces.ChoiceInterface;
import fr.alegent.Swingy.Models.Items.Armors.*;
import fr.alegent.Swingy.Models.Items.Helms.*;
import fr.alegent.Swingy.Models.Items.Weapons.*;
import lombok.val;

import java.util.*;

public abstract class Item implements ChoiceInterface {

    /**
     * Define type of items that player can found through the game.
     */
    public enum Type {
        HELM, WEAPON, ARMOR;

        public String toString() {
            switch (this) {
                case HELM: return "Helm";
                case WEAPON: return "Weapon";
                case ARMOR: return "Armor";
            }
            return null;
        }
    }

    public abstract Type getType();
    public abstract String getName();
    public abstract String getDescription();
    public abstract int getHealthBonus();
    public abstract int getAttackBonus();
    public abstract int getArmorBonus();
    public abstract int getLuckBonus();

    /**
     * Displaying items stats on console.
     */
    public String toString() {
        return String.format("%s: %s (health: %d - attack: %d - armor %d - luck %d)",
                getType(),
                getName(),
                getHealthBonus(),
                getAttackBonus(),
                getArmorBonus(),
                getLuckBonus());
    }

    public String asChoice() {
        return toString();
    }

    /**
     * All references items in the game.
     */
    static List<Class<? extends Item>> allCases = new ArrayList<Class<? extends Item>>() {{
        // ARMORS
        add(TheGoldenArmor.class);
        add(TheGondorsHorn.class);
        add(TheHawaiianShort.class);
        add(TheLeatherArmor.class);
        add(TheOiledTorso.class);
        add(ThePinkShort.class);
        add(ThePoorMansLoincloth.class);
        add(ThePrincessDress.class);
        add(TheSuit.class);

        // HELMS
        add(TheBarcode.class);
        add(TheCloverHelmet.class);
        add(TheFishHead.class);
        add(TheGoldenHelmet.class);
        add(ThePlasticCrown.class);
        add(TheRedBandanna.class);
        add(TheVeryLongHair.class);

        // WEAPONS
        add(TheBigGun.class);
        add(TheFishingRod.class);
        add(TheGoldenSword.class);
        add(TheLongSword.class);
        add(ThePianoString.class);
        add(TheSassyAnswers.class);
        add(TheShortSword.class);
        add(TheStilettoHeel.class);
        add(TheTreeBranch.class);
    }};
}
