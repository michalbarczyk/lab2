package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

public class MapDirectionTest {

    @Test
    public void next() {

        MapDirection mapDirection = MapDirection.WEST;
        assertTrue(mapDirection.next() == MapDirection.NORTH);

        mapDirection = MapDirection.NORTH;
        assertTrue(mapDirection.next() == MapDirection.EAST);

        mapDirection = MapDirection.EAST;
        assertTrue(mapDirection.next() == MapDirection.SOUTH);

        mapDirection = MapDirection.SOUTH;
        assertTrue(mapDirection.next() == MapDirection.WEST);
    }

    @Test
    public void prev() {

        MapDirection mapDirection = MapDirection.WEST;
        assertTrue(mapDirection.prev() == MapDirection.SOUTH);

        mapDirection = MapDirection.SOUTH;
        assertTrue(mapDirection.prev() == MapDirection.EAST);

        mapDirection = MapDirection.EAST;
        assertTrue(mapDirection.prev() == MapDirection.NORTH);

        mapDirection = MapDirection.NORTH;
        assertTrue(mapDirection.prev() == MapDirection.WEST);

    }
}