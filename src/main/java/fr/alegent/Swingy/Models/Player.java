package fr.alegent.Swingy.Models;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public final String name;
    public final Origin origin;
    public final List<Item> inventory;
    public final Equipment equipment;
    public Coordinate coordinate;
    // --Commented out by Inspection (2019-05-10 13:11):private final int level;
    private final int health;
    private final int maxHP;
    private final int attack;
    private final int armor;
    private final int luck;

//    enum LevelUpType {
//        HEALTH, ARMOR, ATTACK, LUCK
//    }

    public Player(String name, Origin origin) {
        //noinspection ConstantConditions
        this.equipment = new Equipment(origin.equipment);
        this.name = name;
        this.origin = origin;
        this.inventory = new ArrayList<>();
//        this.level = origin.level;
        this.maxHP = origin.health;
        this.attack = origin.attack;
        this.armor = origin.armor;
        this.luck = origin.luck;
        this.health = getMaxHP();
    }

// --Commented out by Inspection START (2019-05-10 13:10):
//    public int getLevel() {
//        return level;
//    }
// --Commented out by Inspection STOP (2019-05-10 13:10)

// --Commented out by Inspection START (2019-05-10 13:08):
//    public void addLevel(LevelUpType type) {
//        switch (type) {
//            case HEALTH:
//                maxHP += 1;
//                break;
//            case ATTACK:
//                attack += 1;
//                break;
//            case ARMOR:
//                armor += 1;
//                break;
//            case LUCK:
//                luck += 1;
//                break;
//        }
//
//        this.level += 1;
//        this.health = getMaxHP();
//    }
// --Commented out by Inspection STOP (2019-05-10 13:08)

    public int getHealth() {
        return health;
    }

// --Commented out by Inspection START (2019-05-10 13:12):
//    public void setHealth(int health) {
//        val maxHP = getMaxHP();
//        if (health < 0) this.health = 0;
//        else if (health > maxHP) this.health = maxHP;
//        else this.health = health;
//    }
// --Commented out by Inspection STOP (2019-05-10 13:12)

    public int getMaxHP() {
        return maxHP + equipment.getHealth();
    }

    public int getAttack() {
        return attack + equipment.getAttack();
    }

    public int getArmor() {
        return armor + equipment.getArmor();
    }

    public int getLuck() {
        return luck + equipment.getAttack();
    }

}
