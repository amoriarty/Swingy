package fr.alegent.Swingy.Models;

import lombok.var;

public class Equipment {
    public Item helm;
    public Item armor;
    public Item weapon;

    @SuppressWarnings("ConstantConditions")
    Equipment(Origin.Equipment equipment) {
        this.helm = equipment.helm;
        this.armor = equipment.armor;
        this.weapon = equipment.weapon;
    }

    int getHealth() {
        var points = 0;
        if (helm != null) points += helm.health;
        if (armor != null) points += armor.health;
        if (weapon != null) points += weapon.health;
        return points;
    }

    int getAttack() {
        var points = 0;
        if (helm != null) points += helm.health;
        if (armor != null) points += armor.health;
        if (weapon != null) points += weapon.health;
        return points;
    }

    int getArmor() {
        var points = 0;
        if (helm != null) points += helm.health;
        if (armor != null) points += armor.health;
        if (weapon != null) points += weapon.health;
        return points;
    }

    public Item getItem(Item.Type type) {
        switch (type) {
            case HELM: return helm;
            case ARMOR: return armor;
            case WEAPON: return weapon;
        }

        return null;
    }

    @SuppressWarnings("ConstantConditions")
    public void set(Item item) {
        switch (item.type) {
            case HELM:
                helm = item;
                break;
            case ARMOR:
                armor = item;
                break;
            case WEAPON:
                weapon = item;
                break;
        }
    }

}
