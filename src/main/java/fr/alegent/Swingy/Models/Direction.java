package fr.alegent.Swingy.Models;

import fr.alegent.Swingy.Interfaces.ChoiceInterface;

/**
 * Representation of possible direction a character can take.
 */
public enum Direction implements ChoiceInterface {
    NORTH, SOUTH, EAST, WEST;

    public static Direction[] allCases = {
            NORTH, SOUTH, EAST, WEST
    };

    public String asChoice() {
        switch (this) {
            case NORTH: return "North";
            case EAST: return "East";
            case SOUTH: return "South";
            case WEST: return "West";
        }

        return null;
    }
}
