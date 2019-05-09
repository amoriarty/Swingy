package fr.alegent.Swingy.Models;

public class Enemy {
    public final String name = null;
    public final String description = null;
    public final Integer level = 0;
    public final Integer health = 0;
    public final Integer attack = 0;
    public final Integer armor = 0;
    public final Integer luck = 0;

    public String toString() {
        //noinspection ConstantConditions
        return String.format("%s - %s", name, description);
    }
}
