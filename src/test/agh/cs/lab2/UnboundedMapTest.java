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

    @Test
    public void testRun() {

        List<HayStack> hayStacks = new ArrayList<>();
        hayStacks.add(new HayStack(new Vector(7, 7)));
        hayStacks.add(new HayStack(new Vector(3, 6)));
        hayStacks.add(new HayStack(new Vector(2, 0)));

        IWorldMap map = new UnboundedMap(hayStacks);
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f","f","r","l","r","l","f","f","l"});
        map.place(new Car(map));
        map.place(new Car(map, new Vector(20,-46)));
        map.run(directions);
        assertEquals(new Vector(2,2), ((UnboundedMap) map).getCarByIndex(0).getVector());
        assertEquals(new Vector(20,-46), ((UnboundedMap) map).getCarByIndex(1).getVector());
        assertEquals(MapDirection.EAST, ((UnboundedMap) map).getCarByIndex(0).getDirection());
        assertEquals(MapDirection.SOUTH, ((UnboundedMap) map).getCarByIndex(1).getDirection());

        IWorldMap map2 = new UnboundedMap(hayStacks); // collision with hayStack
        map2.place(new Car(map2));
        ((UnboundedMap) map2).getCarByIndex(0).move(MoveDirection.BACKWARD);
        ((UnboundedMap) map2).getCarByIndex(0).move(MoveDirection.BACKWARD);
        assertEquals(new Vector(2,1), ((UnboundedMap) map2).getCarByIndex(0).getVector());

    }
}