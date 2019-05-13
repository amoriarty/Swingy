package fr.alegent.Swingy.Models;

import lombok.val;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public final String name;
    public final Origin origin;
    public final List<Item> inventory;
    public final Equipment equipment;
    public Coordinate coordinate;
    public Integer health;
    // --Commented out by Inspection (2019-05-10 13:11):private final int level;
    private final Integer maxHP;
    private final Integer attack;
    private final Integer armor;
    private final Integer luck;



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

    // TODO: That belongs to a controller.
//    enum LevelUpType {
//        HEALTH, ARMOR, ATTACK, LUCK
//    }
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

    public Integer getMaxHP() {
        val points = maxHP + equipment.getHealth();
        return points > 0 ? points : 0;
    }

    public Integer getAttack() {
        val points = attack + equipment.getAttack();
        return points > 0 ? points : 0;
    }

    public Integer getArmor() {
        val points = armor + equipment.getArmor();
        return points > 0 ? points : 0;
    }

    public Integer getLuck() {
        val points = luck + equipment.getAttack();
        return points > 0 ? points : 0;
    }

}
