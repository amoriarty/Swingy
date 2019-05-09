package fr.alegent.Swingy.Models;

public class Origin {
    public final String name = null;
    public final String description = null;
    public final Integer level = 0;
    public final Integer health = 0;
    public final Integer attack = 0;
    public final Integer armor = 0;
    public final Integer luck = 0;
    public final Origin.Equipment equipment = null;

    static class Equipment {
        public final Item helm = null;
        public final Item armor = null;
        public final Item weapon = null;
    }

    public String toString() {
        //noinspection ConstantConditions
        return name;
    }
}
