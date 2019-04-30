package fr.alegent.Swingy.Models;

import lombok.Data;

/**
 * Data representation of a game state,
 * which can easily be provide to a window controller in order to display game data.
 */
public @Data class State {
    private Stage stage;
    private Player player;
}
