package fr.alegent.Swingy.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 * Coordinates representation into a map.
 */
@AllArgsConstructor() public @Data class Coordinate {

    /**
     * Horizontal and vertical position in the map.
     */
    @NotNull @PositiveOrZero
    private int x, y;

}
