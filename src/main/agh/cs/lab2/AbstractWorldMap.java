package agh.cs.lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractWorldMap implements IWorldMap {

    private List<Car> carsOnMap;
    private Map<Vector,Car> mapOfCarsOnMap;

    protected AbstractWorldMap() {

        this.carsOnMap = new ArrayList<Car>();
        this.mapOfCarsOnMap = new HashMap<>();
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
            this.mapOfCarsOnMap.put(car.getVector(), car);
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

        return mapOfCarsOnMap.get(vector) != null;
    }

    public Object objectAt(Vector vector) {

        return mapOfCarsOnMap.get(vector);
    }

    public Car getCarByIndex(int index) {

        return carsOnMap.get(index);
    }
}
