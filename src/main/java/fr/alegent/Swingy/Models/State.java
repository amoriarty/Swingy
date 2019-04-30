package fr.alegent.Swingy.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data representation of a game state,
 * which can easily be provide to a window controller in order to display game data.
 */
@AllArgsConstructor
public @Data class State {
    private Stage stage;
}
