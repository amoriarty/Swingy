package fr.alegent.Swingy.Models;

import fr.alegent.Swingy.Interfaces.ChoiceInterface;

public enum FreeModeActions implements ChoiceInterface {
    MOVE, STATS, QUIT;

    public static FreeModeActions[] allCases = {
            MOVE, STATS, QUIT
    };

    public String asChoice() {
        switch (this) {
            case MOVE: return "Move";
            case STATS: return "Show statistics";
            case QUIT: return "Quit game";
        }

        return null;
    }
}
