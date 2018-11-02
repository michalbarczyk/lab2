package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegrationTest {

    @Test
    public void testMapBorder() {

        Car testCar = new Car();
        testCar.move(MoveDirection.BACKWARD);
        testCar.move(MoveDirection.BACKWARD);
        testCar.move(MoveDirection.BACKWARD);
        assertEquals(new Vector(2, 0), testCar.getCarVector());
        assertEquals(MapDirection.NORTH, testCar.getCarDirection());

        testCar.move(MoveDirection.RIGHT);
        testCar.move(MoveDirection.FORWARD);
        testCar.move(MoveDirection.FORWARD);
        testCar.move(MoveDirection.FORWARD);
        testCar.move(MoveDirection.FORWARD);
        testCar.move(MoveDirection.FORWARD);
        testCar.move(MoveDirection.FORWARD);
        assertEquals(new Vector(4, 0), testCar.getCarVector());
        assertEquals(MapDirection.EAST, testCar.getCarDirection());

        testCar.move(MoveDirection.LEFT);
        testCar.move(MoveDirection.FORWARD);
        testCar.move(MoveDirection.FORWARD);
        testCar.move(MoveDirection.FORWARD);
        assertEquals(new Vector(4, 3), testCar.getCarVector());
        assertEquals(MapDirection.NORTH, testCar.getCarDirection());
    }

    @Test
    public void testDirection() {

        Car testCar = new Car(0, 0, MapDirection.WEST);
        testCar.move(MoveDirection.LEFT);
        testCar.move(MoveDirection.LEFT);
        assertEquals(MapDirection.EAST, testCar.getCarDirection());

        testCar.move(MoveDirection.RIGHT);
        testCar.move(MoveDirection.RIGHT);
        testCar.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.NORTH, testCar.getCarDirection());
    }

    @Test
    public void testWithOptionsParser() {

        Car testCar = new Car(2, 2, MapDirection.NORTH);
        MoveDirection[] moveTable = OptionsParser.parse(new String[]
                {"t","f","r","f","r","f","f","r","f","f","l","b","v","b","b","301","l","f","f","f","l","k","r"});

        for (MoveDirection moveDirection : moveTable) {

            testCar.move(moveDirection);
        }
        assertEquals(MapDirection.EAST, testCar.getCarDirection());
        assertEquals(new Vector(4, 4), testCar.getCarVector());
    }
}
