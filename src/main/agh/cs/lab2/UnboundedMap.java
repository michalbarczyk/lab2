package agh.cs.lab2;

import java.util.List;

public class UnboundedMap implements IWorldMap {

    private List<HayStack> hayStacksOnMap;
    private List<Car> carsOnMap;

    UnboundedMap(List<HayStack> hayStacks) {

        this.hayStacksOnMap = hayStacks;
    }

    private Vector getUpRightCorner() {

        Vector upRightVector = carsOnMap.get(0).getVector();

        for (Car car : carsOnMap) {

            upRightVector = upRightVector.upperRight(car.getVector());
        }

        for (HayStack hayStack : hayStacksOnMap) {

            upRightVector = upRightVector.upperRight(hayStack.getVector());
        }

        return upRightVector;
    }

    private Vector getDownLeftCorner() {

        Vector downLeftVector = carsOnMap.get(0).getVector();

        for (Car car : carsOnMap) {

            downLeftVector = downLeftVector.lowerLeft(car.getVector());
        }

        for (HayStack hayStack : hayStacksOnMap) {

            downLeftVector = downLeftVector.lowerLeft(hayStack.getVector());
        }

        return downLeftVector;
    }

    public String toString() {

        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(this.getDownLeftCorner(), this.getUpRightCorner());
    }

    public boolean canMoveTo(Vector vector) {

        return !isOccupied(vector);
    }

    public boolean place(Car car) {
        if (this.canMoveTo(car.getVector())) {
            this.carsOnMap.add(car);
            return true;
        }
        else return false;

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

        for (HayStack hayStack : hayStacksOnMap) {
            if (hayStack.getVector().equals(vector))
                return true;
        }
        return false;
    }

    public Object objectAt(Vector vector) {

        for (Car car : carsOnMap) {
            if (car.getVector().equals(vector))
                return car;
        }

        for (HayStack hayStack : hayStacksOnMap) {
            if (hayStack.getVector().equals(vector))
                return hayStack;
        }

        return null;
    }

    public Car getCarByIndex(int index) {

        return carsOnMap.get(index);
    }


}
