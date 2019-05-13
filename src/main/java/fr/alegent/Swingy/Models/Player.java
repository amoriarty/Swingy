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
    public Integer level;
    public Integer xp = 0;
    public Integer maxHP;
    public Integer attack;
    public Integer armor;
    public Integer luck;

    public Player(String name, Origin origin) {
        //noinspection ConstantConditions
        this.equipment = new Equipment(origin.equipment);
        this.name = name;
        this.origin = origin;
        this.inventory = new ArrayList<>();
        this.level = origin.level;
        this.maxHP = origin.health;
        this.attack = origin.attack;
        this.armor = origin.armor;
        this.luck = origin.luck;
        this.health = getMaxHP();
    }

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

    public Integer nextLevel() {
        return level * 1000 + ((level - 1) * (level - 1)) * 450;
    }

}
