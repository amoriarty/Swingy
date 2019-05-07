package fr.alegent.Swingy.Models;

public class Item {
    public final Type type = null;
    @SuppressWarnings("WeakerAccess")
    public final String name = null;
    @SuppressWarnings("WeakerAccess")
    public final String description = null;
    @SuppressWarnings("WeakerAccess")
    public final Integer health = 0;
    @SuppressWarnings("WeakerAccess")
    public final Integer attack = 0;
    @SuppressWarnings("WeakerAccess")
    public final Integer armor = 0;
    @SuppressWarnings("WeakerAccess")
    public final Integer luck = 0;

    enum Type {
        HELM, ARMOR, WEAPON
    }

    public String toString() {
        //noinspection ConstantConditions
        return String.format(
                "%s - health: %d - attack: %d - armor: %d - luck: %d\n\t-- %s",
                name,
                health,
                attack,
                armor,
                luck,
                description
        );
    }
}
