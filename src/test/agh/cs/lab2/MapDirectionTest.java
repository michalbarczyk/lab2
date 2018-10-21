package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

public class MapDirectionTest {

    @Test
    public void next() {

        MapDirection mapDirection = MapDirection.WEST;
        assertTrue(mapDirection.next() == MapDirection.NORTH);
        assertFalse(mapDirection.next() == MapDirection.SOUTH);

    }

    @Test
    public void prev() {
    }
}