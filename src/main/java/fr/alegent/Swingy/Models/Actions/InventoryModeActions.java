package fr.alegent.Swingy.Models.Actions;

import fr.alegent.Swingy.Interfaces.ChoiceInterface;

public enum InventoryModeActions implements ChoiceInterface {
    EQUIP, UNEQUIPPED, RETURN;

    public static InventoryModeActions[] allCases = {
            EQUIP, UNEQUIPPED, RETURN
    };

    public String asChoice() {
        switch (this) {
            case EQUIP: return "Equip";
            case UNEQUIPPED: return "Unequipped";
            case RETURN: return "Return";
        }
        return null;
    }
}
