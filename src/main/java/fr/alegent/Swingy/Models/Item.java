package fr.alegent.Swingy.Models;

@SuppressWarnings("WeakerAccess")
public class Item {
    public final Type type = null;
    public final String name = null;
    public final String description = null;
    public final Integer health = 0;
    public final Integer attack = 0;
    public final Integer armor = 0;
    public final Integer luck = 0;

    public enum Type {
        HELM, ARMOR, WEAPON
    }

    public String toString() {
        //noinspection ConstantConditions
        return String.format(
                "%s - health: %d - attack: %d - armor: %d - luck: %d -- %s",
                name,
                health,
                attack,
                armor,
                luck,
                description
        );
    }
}
