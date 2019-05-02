package fr.alegent.Swingy.Models.Actions;

import fr.alegent.Swingy.Interfaces.ChoiceInterface;

public enum FreeModeActions implements ChoiceInterface {
    MOVE, STATS, INVENTORY, QUIT;

    public static FreeModeActions[] allCases = {
            MOVE, STATS, INVENTORY, QUIT
    };

    public String asChoice() {
        switch (this) {
            case MOVE: return "Move";
            case STATS: return "Show statistics";
            case INVENTORY: return "Show inventory";
            case QUIT: return "Quit game";
        }

        return null;
    }
}
