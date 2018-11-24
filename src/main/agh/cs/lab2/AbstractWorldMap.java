package agh.cs.lab2;

import java.util.*;

public class AbstractWorldMap implements IWorldMap {

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
            return true;
        }
        else throw new IllegalArgumentException(car.getVector().toString() + " is already occupied");

    }

    public void run(MoveDirection[] directions) {

        for (int i = 0; i < directions.length; i++) {

            Car carToBeMoved = carsOnMapList.get(i%carsOnMapList.size());
            Vector prevVector = carToBeMoved.getVector();
            carToBeMoved.move(directions[i]);
            if (!prevVector.equals(carToBeMoved.getVector())) {

                this.carsOnMapMap.remove(prevVector);
                this.carsOnMapMap.put(carToBeMoved.getVector(), carToBeMoved);
            }

        }

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
