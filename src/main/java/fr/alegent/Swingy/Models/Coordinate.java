package fr.alegent.Swingy.Models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.val;

import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Coordinate {
    public Integer x, y;

    public Coordinate(Coordinate coordinate) {
        this(coordinate.x, coordinate.y);
    }

    static Coordinate random(int size) {
        val x = new Random().nextInt(size);
        val y = new Random().nextInt(size);
        return new Coordinate(x, y);
    }
}
