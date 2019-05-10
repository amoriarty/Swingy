package fr.alegent.Swingy.Models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.val;

import java.util.Random;

@AllArgsConstructor
@EqualsAndHashCode
public class Coordinate {
    public int x, y;

    static Coordinate random(int size) {
        val x = new Random().nextInt(size);
        val y = new Random().nextInt(size);
        return new Coordinate(x, y);
    }
}
