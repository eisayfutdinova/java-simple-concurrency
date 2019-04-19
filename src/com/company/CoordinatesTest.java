package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    void move() {
        Coordinates coord = new Coordinates(5.0, 4.0);
        double alpha = Math.toRadians(60);
        coord.setX(coord.move(coord.getX(), alpha, 5, true));
        assertEquals(coord.getX(), 7.5);

        coord.setY(coord.move(coord.getY(), Math.toRadians(30), 1, false));
        assertEquals(coord.getY(), 4.5);
    }
}