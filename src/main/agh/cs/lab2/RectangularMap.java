package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {

    List<Car> cars = new ArrayList<>();

    private int height;
    private int width;

    public RectangularMap (int width, int height) {

        this.height = height;
        this.width = width;
    }

    boolean canMoveTo(Vector position) {

        for (Car car : cars) {

            if (car.getCarVector().equals(position))
                return false;
        }
        return true;
    }

    /**
     * Place a car on the map.
     *
     * @param car
     *            The car to place on the map.
     * @return True if the car was placed. The car cannot be placed if the map is already occupied.
     */
    boolean place(Car car) {

    }

    /**
     * Move the cars on the map according to the provided move directions. Every
     * n-th direction should be sent to the n-th car on the map.
     *
     * @param directions
     *            Array of move directions.
     */
    void run(MoveDirection[] directions) {

    }

    /**
     * Return true if given position on the map is occupied. Should not be
     * confused with canMove since there might be empty positions where the car
     * cannot move.
     *
     * @param position
     *            Position to check.
     * @return True if the position is occupied.
     */
    boolean isOccupied(Vector position) {

    }

    /**
     * Return an object at a given position.
     *
     * @param position
     *            The position of the object.
     * @return Object or null if the position is not occupied.
     */
    Object objectAt(Vector position) {

    }

}
