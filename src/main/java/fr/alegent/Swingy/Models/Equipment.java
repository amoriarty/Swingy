package fr.alegent.Swingy.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.var;

/**
 * Equipment representation of player
 */
@Getter
@Setter
@AllArgsConstructor
public class Equipment {
    private Item helm;
    private Item armor;
    private Item weapon;

    /**
     * Wrapper to get health points provided by equipment.
     * @return Health bonus provided by equipment.
     */
    public int getHealthBonus() {
        var bonus = 0;
        if (helm != null) { bonus += helm.getHealthBonus(); }
        if (armor != null) { bonus += armor.getHealthBonus(); }
        if (weapon != null) { bonus += weapon.getHealthBonus(); }
        return bonus;
    }

    /**
     * Wrapper to get attack points provided by equipment.
     * @return Attack bonus provided by equipment.
     */
    public int getAttackBonus() {
        var bonus = 0;
        if (helm != null) { bonus += helm.getAttackBonus(); }
        if (armor != null) { bonus += armor.getAttackBonus(); }
        if (weapon != null) { bonus += weapon.getAttackBonus(); }
        return bonus;
    }

    /**
     * Wrapper to get armor points provided by equipment.
     * @return Armor bonus provided by equipment.
     */
    public int getArmorBonus() {
        var bonus = 0;
        if (helm != null) { bonus += helm.getArmorBonus(); }
        if (armor != null) { bonus += armor.getArmorBonus(); }
        if (weapon != null) { bonus += weapon.getArmorBonus(); }
        return bonus;
    }

    /**
     * Wrapper to get luck points provided by equipment.
     * @return Luck bonus provided by equipment.
     */
    public int getLuckBonus() {
        var bonus = 0;
        if (helm != null) { bonus += helm.getLuckBonus(); }
        if (armor != null) { bonus += armor.getLuckBonus(); }
        if (weapon != null) { bonus += weapon.getLuckBonus(); }
        return bonus;
    }
}
