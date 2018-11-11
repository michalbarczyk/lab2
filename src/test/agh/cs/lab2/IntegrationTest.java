package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegrationTest {

    @Test
    public void testMapBorder() {

        IWorldMap map = new RectangularMap(5,5);

        Car testCar = new Car(map);
        testCar.move(MoveDirection.BACKWARD);
        testCar.move(MoveDirection.BACKWARD);
        testCar.move(MoveDirection.BACKWARD);
        assertEquals(new Vector(2, 0), testCar.getVector());
        assertEquals(MapDirection.NORTH, testCar.getDirection());

        testCar.move(MoveDirection.RIGHT);
        testCar.move(MoveDirection.FORWARD);
        testCar.move(MoveDirection.FORWARD);
        testCar.move(MoveDirection.FORWARD);
        testCar.move(MoveDirection.FORWARD);
        testCar.move(MoveDirection.FORWARD);
        testCar.move(MoveDirection.FORWARD);
        assertEquals(new Vector(4, 0), testCar.getVector());
        assertEquals(MapDirection.EAST, testCar.getDirection());

        testCar.move(MoveDirection.LEFT);
        testCar.move(MoveDirection.FORWARD);
        testCar.move(MoveDirection.FORWARD);
        testCar.move(MoveDirection.FORWARD);
        assertEquals(new Vector(4, 3), testCar.getVector());
        assertEquals(MapDirection.NORTH, testCar.getDirection());
    }


    @Test
    public void testWithOptionsParser() {

        IWorldMap map = new RectangularMap(5,5);

        Car testCar = new Car(map);
        MoveDirection[] moveTable = OptionsParser.parse(new String[]
                {"t","f","r","f","r","f","f","r","f","f","l","b","v","b","b","301","l","f","f","f","l","k","r"});

        for (MoveDirection moveDirection : moveTable) {

            testCar.move(moveDirection);
        }
        assertEquals(MapDirection.EAST, testCar.getDirection());
        assertEquals(new Vector(4, 4), testCar.getVector());
    }
}
