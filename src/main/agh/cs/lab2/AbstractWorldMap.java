package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class AbstractWorldMap implements IWorldMap {

    private List<Car> carsOnMap;

    protected AbstractWorldMap() {

        this.carsOnMap = new ArrayList<Car>();
    }

    protected List<Car> getCarsOnMap() {

        return carsOnMap;
    }

    public boolean canMoveTo(Vector vector) {

        return !isOccupied(vector);
    }

    public boolean place(Car car) throws IllegalArgumentException {
        if (this.canMoveTo(car.getVector())) {
            this.carsOnMap.add(car);
            return true;
        }
        else throw new IllegalArgumentException(car.getVector().toString() + " is already occupied");

    }

    public void run(MoveDirection[] directions) {
        for (int i = 0; i < directions.length; i++) {
            carsOnMap.get(i%carsOnMap.size()).move(directions[i]);
        }
    }

    public boolean isOccupied(Vector vector) {

        for (Car car : carsOnMap) {
            if (car.getVector().equals(vector))
                return true;
        }
        return false;
    }

    public Object objectAt(Vector vector) {

        for (Car car : carsOnMap) {
            if (car.getVector().equals(vector))
                return car;
        }

        return null;
    }

    public Car getCarByIndex(int index) {

        return carsOnMap.get(index);
    }
}
