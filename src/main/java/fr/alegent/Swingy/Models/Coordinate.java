package fr.alegent.Swingy.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.val;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;
import java.util.Random;

/**
 * Coordinates representation into a map.
 */
@AllArgsConstructor()
public @Data class Coordinate {

    /**
     * Horizontal and vertical position in the map.
     */
    @NotNull
    @PositiveOrZero
    private int x, y;

    public Coordinate random(int size) {
        val now = (int) new Date().getTime();
        val seed = new Random(now).nextInt();
        val x = new Random(seed).nextInt(size);
        val y = new Random(seed).nextInt(size);
        return new Coordinate(x, y);
    }
}
