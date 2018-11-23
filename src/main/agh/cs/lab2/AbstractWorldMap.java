package agh.cs.lab2;

import java.util.*;

public class AbstractWorldMap implements IWorldMap {

    private Map<Vector,Car> carsOnMap;


    protected AbstractWorldMap() {

        this.carsOnMap = new LinkedHashMap<>();
    }

    protected Map<Vector,Car> getCarsOnMap() {

        return carsOnMap;
    }

    public boolean canMoveTo(Vector vector) {

        return !isOccupied(vector);
    }

    public boolean place(Car car) throws IllegalArgumentException {
        if (this.canMoveTo(car.getVector())) {
            this.carsOnMap.put(car.getVector(), car);
            return true;
        }
        else throw new IllegalArgumentException(car.getVector().toString() + " is already occupied");

    }

    public void run(MoveDirection[] directions) {

        Iterator<Map.Entry<Vector, Car>> it = carsOnMap.entrySet().iterator();

        for (int i = 0; i < directions.length; i++) {

            Map.Entry<Vector, Car> entry =  it.next();
            Car car = entry.getValue();
            car.move(directions[i]);

            if (!car.getVector().equals(entry.getKey())) {

                carsOnMap.remove(prevVector);
                carsOnMap.put(car.getVector(), car);
            }

            if (!it.hasNext())
                it = carsOnMap.keySet().iterator();
        }

    }

    public boolean isOccupied(Vector vector) {

        return carsOnMap.get(vector) != null;
    }

    public Object objectAt(Vector vector) {

        return carsOnMap.get(vector);
    }

    public Car getCarByIndex(int index) {

        return carsOnMap.get(index);
    }
}
