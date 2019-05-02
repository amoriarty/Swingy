package fr.alegent.Swingy.Models;

/**
 * Game stage representation.
 */
public enum Stage {
    /**
     * Player character creation.
     */
    CHARACTER_CREATION,

    /**
     * Generate next mission.
     */
    MISSION_GENERATION,

    /**
     * Player is in the world and can move freely or manage it's inventory.
     */
    FREE,

    /**
     * Player is able to move in one of the four directions.
     */
    MOVE,

    /**
     * Game checking current state to know if player pass the mission, enter a combat or loot something
     */
    CHECK,

    /**
     * Player ask to quit the game.
     */
    QUIT
}
