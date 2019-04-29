package fr.alegent.Swingy.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor()
public @Data class Coordinate {

    /**
     * Horizontal and vertical position in the map.
     */
    @NotNull @PositiveOrZero
    private int x, y;

}
