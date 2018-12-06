package agh.cs.lab2;

import java.util.*;

public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    private Map<Vector,Car> carsOnMapMap;
    private List<Car> carsOnMapList;


    protected AbstractWorldMap() {

        this.carsOnMapMap = new HashMap<>();
        this.carsOnMapList = new LinkedList<>();
    }

    protected List<Car> getCarsOnMapList() {

        return carsOnMapList;
    }

    public boolean canMoveTo(Vector vector) {

        return !isOccupied(vector);
    }

    public boolean place(Car car) throws IllegalArgumentException {
        if (this.canMoveTo(car.getVector())) {
            this.carsOnMapMap.put(car.getVector(), car);
            this.carsOnMapList.add(car);
            car.addObserver(this); // here or, for instance in Car constructor?
            return true;
        }
        else throw new IllegalArgumentException(car.getVector().toString() + " is already occupied");

    }

    public void run(MoveDirection[] directions) {

        for (int i = 0; i < directions.length; i++) {

            Car carToBeMoved = carsOnMapList.get(i%carsOnMapList.size());
            carToBeMoved.move(directions[i]);
        }

    }

    @Override
    public void positionChanged(Vector oldVector, Vector newVector) {

        Car car = carsOnMapMap.remove(oldVector);
        this.carsOnMapMap.put(newVector, car);
    }

    public boolean isOccupied(Vector vector) {

        return carsOnMapMap.get(vector) != null;
    }

    public Object objectAt(Vector vector) {

        return carsOnMapMap.get(vector);
    }

    public Car getCarByIndex(int index) {

        return carsOnMapMap.get(index);
    }
}
