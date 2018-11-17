package agh.cs.lab2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class RectangularMapTest extends AbstractWorldMap {

    @Test
    public void testCanMoveTo() {

        IWorldMap map = new RectangularMap(4,4);
        assertTrue(map.canMoveTo(new Vector(0,0)));
        assertTrue(map.canMoveTo(new Vector(3,3)));
        //assertFalse(map.canMoveTo(new Vector(1,0)));
        //assertFalse(map.canMoveTo(new Vector(4,4)));

    }

    @Test
    public void testRun() {

        IWorldMap map = new RectangularMap(6,6);
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f","f","r","l","r","l","f","f"});
        map.place(new Car(map));
        map.place(new Car(map, new Vector(3,4)));
        map.run(directions);
        assertEquals(new Vector(2,2), ((RectangularMap) map).getCarByIndex(0).getVector());
        assertEquals(new Vector(3,4), ((RectangularMap) map).getCarByIndex(1).getVector());
        assertEquals(MapDirection.SOUTH, ((RectangularMap) map).getCarByIndex(0).getDirection());
        assertEquals(MapDirection.SOUTH, ((RectangularMap) map).getCarByIndex(1).getDirection());
    }

    @Test
    public void testIsOccupied() {

        IWorldMap map = new RectangularMap(16,23);
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f","f","f","b","f"});
        map.place(new Car(map));
        map.place(new Car(map, new Vector(4,4)));
        map.run(directions);
        assertTrue(map.isOccupied(new Vector(2,5)));
        assertTrue(map.isOccupied(new Vector(4,4)));
        assertFalse(map.isOccupied(new Vector(15,16)));

    }

    @Test
    public void testObjectAt() {
    }
}