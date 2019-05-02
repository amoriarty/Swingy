package fr.alegent.Swingy.Models;

import fr.alegent.Swingy.Interfaces.ChoiceInterface;

public enum FreeModeActions implements ChoiceInterface {
    MOVE, QUIT;

    public static FreeModeActions[] allCases = {
            MOVE, QUIT
    };

    public String asChoice() {
        switch (this) {
            case MOVE: return "Move";
            case QUIT: return "Quit game";
        }

        return null;
    }
}
