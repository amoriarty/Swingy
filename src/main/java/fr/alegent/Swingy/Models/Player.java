package fr.alegent.Swingy.Models;

import fr.alegent.Swingy.Interfaces.ChoiceInterface;
import fr.alegent.Swingy.Models.Items.Armors.*;
import fr.alegent.Swingy.Models.Items.Helms.*;
import fr.alegent.Swingy.Models.Items.Weapons.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.val;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;

@Getter
@Setter
@RequiredArgsConstructor
public class Player {

    /**
     * Name of the character.
     */
    private String name;

    /**
     * Based origin of the character.
     */
    private Origin origin;

    /**
     * Current coordinate of the player.
     */
    private Coordinate coordinate;

    /**
     * Player equipment;
     */
    private Equipment equipment;

    /**
     * Current health point of the player, without items bonuses.
     */
    @PositiveOrZero
    private int health;

    /**
     * Maximum health player can have.
     */
    @PositiveOrZero
    private int healthMax;

    /**
     * Current armor points of the player, without items bonuses.
     */
    @PositiveOrZero
    private int armor;

    /**
     * Current attack points of the player, without items bonuses.
     */
    @PositiveOrZero
    private int attack;

    /**
     * Current luck points of the player, without items bonuses.
     */
    @PositiveOrZero
    private int luck;

    /**
     * Current level of the player.
     */
    @Positive
    private int level;

    /**
     * Current xp points of the player.
     */
    @PositiveOrZero
    private int xp;

    /**
     * Player items inventory.
     */
    private ArrayList<Item> inventory = new ArrayList<>();

    /**
     * Get maximum health points player can have, considering origin and equipment.
     * @return Max health player can have.
     */
    public int getHealthMax() {
        return healthMax + equipment.getHealthBonus();
    }

    /**
     * Get attack point of the player, considering character and it's equipment.
     * @return Attack points of the player.
     */
    public int getAttack() {
        return attack + equipment.getAttackBonus();
    }

    /**
     * Get armor points of the player, considering character and it's equipment.
     * @return Armor points of the player.
     */
    public int getArmor() {
        return armor + equipment.getArmorBonus();
    }

    /**
     * Get luck points of the player, considering character and it's equipment.
     * @return Luck point of the player.
     */
    public int getLuck() {
        return armor + equipment.getLuckBonus();
    }

    /**
     * Setting all based stats of player from a defined origin.
     * @param origin Based origin choosed by player.
     */
    public void setOrigin(Origin origin) {
        this.origin = origin;
        this.level = origin.getLevel();
        this.equipment = origin.getEquipment();
        this.healthMax = origin.getHealth();
        this.health = this.healthMax + this.equipment.getHealthBonus();
        this.armor = origin.getArmor();
        this.attack = origin.getAttack();
        this.luck = origin.getLuck();
    }

    /**
     * Considered as classes in most RPG, constants defined starter player stats.
     */
    public enum Origin implements ChoiceInterface {
        THE_NORMAL_DUDE, THE_RAMBO, THE_BARBIE, THE_OLD_MAN_AND_THE_SEA,
        THE_47, THE_LIEUTENANT_DAN, THE_DADDYS_BOY, THE_BOROMIR, THE_MINCEMEAT;

        /**
         * All origins, indexed.
         */
        public static Origin[] allCases = {
                THE_NORMAL_DUDE, THE_RAMBO, THE_BARBIE, THE_OLD_MAN_AND_THE_SEA,
                THE_47, THE_LIEUTENANT_DAN, THE_DADDYS_BOY, THE_BOROMIR, THE_MINCEMEAT
        };

        /**
         * Human readable origins names.
         */
        public String getName() {
            switch (this) {
                case THE_NORMAL_DUDE: return "The Normal Dude";
                case THE_RAMBO: return "The Rambo";
                case THE_BARBIE: return "The Barbie";
                case THE_OLD_MAN_AND_THE_SEA: return "The Old Man and the Sea";
                case THE_47: return "The 47";
                case THE_LIEUTENANT_DAN: return "The Lieutenant Dan";
                case THE_DADDYS_BOY: return "The Daddy's Boy";
                case THE_BOROMIR: return "The Boromir";
                case THE_MINCEMEAT: return "The Mincemeat";
            }

            return null;
        }

        /**
         * Descriptions of each origins.
         */
        public String getDescription() {
            switch (this) {
                case THE_NORMAL_DUDE: return "As his name suggest, just an ordinary guy who wants to take his chances.";
                case THE_RAMBO: return "It wasn't his war, and he only owes his survival to his luck. And maybe to his muscle too ...";
                case THE_BARBIE: return "Even she wonders why she's here.";
                case THE_OLD_MAN_AND_THE_SEA: return "He may not have much life or luck, but he can knock someone out in one try.";
                case THE_47: return "Do we really need to explain ?";
                case THE_LIEUTENANT_DAN: return "A seasoned soldier. (You may want to keep him away from alcohol though).";
                case THE_DADDYS_BOY: return "Can we really buy victory ? He believes in it.";
                case THE_BOROMIR: return "He's really, really, really unlucky ...";
                case THE_MINCEMEAT: return "The challenge made man. (Life is really not easy for him ...)";
            }

            return null;
        }

        /**
         * Get base level for an origin.
         * @return Base level
         */
        public int getLevel() {
            switch (this) {
                case THE_NORMAL_DUDE:
                case THE_OLD_MAN_AND_THE_SEA:
                case THE_BOROMIR: return 3;
                case THE_RAMBO: return 5;
                case THE_BARBIE: return 2;
                case THE_47:
                case THE_LIEUTENANT_DAN: return 4;
                case THE_MINCEMEAT: return 1;
            }

            return -1;
        }

        /**
         * Get base health points for an origin.
         * @return Base health points for origin.
         */
        public int getHealth() {
            switch (this) {
                case THE_NORMAL_DUDE:
                case THE_OLD_MAN_AND_THE_SEA: return 10;
                case THE_RAMBO:
                case THE_BOROMIR: return 20;
                case THE_BARBIE: return 8;
                case THE_47:
                case THE_DADDYS_BOY: return 15;
                case THE_LIEUTENANT_DAN: return 18;
                case THE_MINCEMEAT: return 5;
            }

            return -1;
        }

        /**
         * Get base armor points for an origin.
         * @return Base armor points.
         */
        public int getArmor() {
            switch (this) {
                case THE_NORMAL_DUDE:
                case THE_RAMBO:
                case THE_BARBIE:
                case THE_47:
                case THE_LIEUTENANT_DAN: return 15;
                case THE_OLD_MAN_AND_THE_SEA:
                case THE_BOROMIR: return 10;
                case THE_DADDYS_BOY: return 20;
                case THE_MINCEMEAT: return 5;
            }

            return -1;
        }

        /**
         * Get base attack for an origin.
         * @return Base attack points.
         */
        public int getAttack() {
            switch (this) {
                case THE_NORMAL_DUDE:
                case THE_47: return 15;
                case THE_RAMBO:
                case THE_OLD_MAN_AND_THE_SEA:
                case THE_LIEUTENANT_DAN: return 20;
                case THE_BARBIE:
                case THE_BOROMIR: return 10;
                case THE_DADDYS_BOY:
                case THE_MINCEMEAT: return 5;
            }

            return -1;
        }

        /**
         * Get base luck points for an origin.
         * @return Base luck points.
         */
        public int getLuck() {
            switch (this) {
                case THE_NORMAL_DUDE:
                case THE_OLD_MAN_AND_THE_SEA: return 10;
                case THE_RAMBO: return 20;
                case THE_BARBIE:
                case THE_BOROMIR: return 0;
                case THE_47:
                case THE_DADDYS_BOY: return 15;
                case THE_LIEUTENANT_DAN:
                case THE_MINCEMEAT: return 5;
            }

            return -1;
        }

        /**
         * Get base equipment for an origin.
         * @return Base equipment for an origin.
         */
        public Equipment getEquipment() {
            switch (this) {
                case THE_NORMAL_DUDE: return new Equipment(new TheCloverHelmet(), new TheLeatherArmor(), new TheShortSword());
                case THE_RAMBO: return new Equipment(new TheRedBandanna(), new TheOiledTorso(), new TheBigGun());
                case THE_BARBIE: return new Equipment(new ThePlasticCrown(), new ThePrincessDress(), new TheStilettoHeel());
                case THE_OLD_MAN_AND_THE_SEA: return new Equipment(new TheFishHead(), new ThePinkShort(), new TheFishingRod());
                case THE_47: return new Equipment(new TheBarcode(), new TheSuit(), new ThePianoString());
                case THE_LIEUTENANT_DAN: return new Equipment(new TheVeryLongHair(), new TheHawaiianShort(), new TheSassyAnswers());
                case THE_DADDYS_BOY: return new Equipment(new TheGoldenHelmet(), new TheGoldenArmor(), new TheGoldenSword());
                case THE_BOROMIR: return new Equipment(null, new TheGondorsHorn(), new TheLongSword());
                case THE_MINCEMEAT: return new Equipment(null, new ThePoorMansLoincloth(), new TheTreeBranch());
            }

            return new Equipment(null, null, null);
        }

        public String asChoice() {
            return String.format("%s - %s", getName(), getDescription());
        }
    }

}
