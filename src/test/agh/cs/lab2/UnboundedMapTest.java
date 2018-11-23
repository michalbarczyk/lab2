package agh.cs.lab2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UnboundedMapTest extends AbstractWorldMap {

    @Test
    public void testIsOccupied() {

        MoveDirection[] directions = OptionsParser.parse(new String[]{"f","f","r","l","r","l","f","f"});
        List<HayStack> hayStacks = new ArrayList<>();
        hayStacks.add(new HayStack(new Vector(-4, -4)));
        hayStacks.add(new HayStack(new Vector(7, 7)));
        hayStacks.add(new HayStack(new Vector(3, 6)));
        hayStacks.add(new HayStack(new Vector(2, 0)));


        IWorldMap map = new UnboundedMap(hayStacks);
        map.place(new Car(map));
        map.place(new Car(map, new Vector(3,4)));
        map.run(directions);

        assertTrue(map.isOccupied(new Vector(7,7)));
        assertTrue(map.isOccupied(new Vector(3,4)));
        assertFalse(map.isOccupied(new Vector(3,5)));
    }
}