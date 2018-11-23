package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {

    private List<HayStack> hayStacksOnMap;

    UnboundedMap(List<HayStack> hayStacks) {

        super();
        this.hayStacksOnMap = hayStacks;
    }

    private Vector getUpRightCorner() {

        Vector upRightVector = super.getCarsOnMap().get(0).getVector(); // random existing car to compare below

        for (Car car : getCarsOnMap()) {

            upRightVector = upRightVector.upperRight(car.getVector());
        }

        for (HayStack hayStack : hayStacksOnMap) {

            upRightVector = upRightVector.upperRight(hayStack.getVector());
        }

        return upRightVector;
    }

    private Vector getDownLeftCorner() {

        Vector downLeftVector = super.getCarsOnMap().get(0).getVector(); // random existing car to compare below

        for (Car car : super.getCarsOnMap()) {

            downLeftVector = downLeftVector.lowerLeft(car.getVector());
        }

        for (HayStack hayStack : hayStacksOnMap) {

            downLeftVector = downLeftVector.lowerLeft(hayStack.getVector());
        }

        return downLeftVector;
    }

    @Override
    public String toString() {

        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(this.getDownLeftCorner(), this.getUpRightCorner());
    }

    @Override
    public boolean canMoveTo(Vector vector) {

        return !isOccupied(vector);
    }

    @Override
    public boolean isOccupied(Vector vector) {

        for (HayStack hayStack : hayStacksOnMap) {
            if (hayStack.getVector().equals(vector))
                return true;
        }

        return super.isOccupied(vector);
    }

    @Override
    public Object objectAt(Vector vector) {

        for (HayStack hayStack : hayStacksOnMap) {
            if (hayStack.getVector().equals(vector))
                return hayStack;
        }

        return super.objectAt(vector);
    }



}
