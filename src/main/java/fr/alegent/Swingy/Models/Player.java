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
    private int level;
    private int health;
    private int maxHP;
    private int attack;
    private int armor;
    private int luck;

    enum LevelUpType {
        HEALTH, ARMOR, ATTACK, LUCK
    }

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

    public int getLevel() {
        return level;
    }

    public void addLevel(LevelUpType type) {
        switch (type) {
            case HEALTH:
                maxHP += 1;
                break;
            case ATTACK:
                attack += 1;
                break;
            case ARMOR:
                armor += 1;
                break;
            case LUCK:
                luck += 1;
                break;
        }

        this.level += 1;
        this.health = getMaxHP();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        val maxHP = getMaxHP();
        if (health < 0) this.health = 0;
        else if (health > maxHP) this.health = maxHP;
        else this.health = health;
    }

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

    public void setItem(Item item) {
        //noinspection ConstantConditions
        switch (item.type) {
            case WEAPON:
                equipment.weapon = item;
                break;
            case ARMOR:
                equipment.armor = item;
                break;
            case HELM:
                equipment.helm = item;
                break;
        }
    }

}
