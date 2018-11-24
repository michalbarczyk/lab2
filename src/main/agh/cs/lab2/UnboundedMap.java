package agh.cs.lab2;

import java.util.*;

public class UnboundedMap extends AbstractWorldMap {

    private Map<Vector, HayStack> hayStacksOnMap;


    public UnboundedMap(List<HayStack> hayStacks) {

        this.hayStacksOnMap = Util.listToLinkedHashMap(hayStacks);
    }

    private Vector getUpRightCorner() {

        Vector upRightVector = getCarsOnMapList().get(0).getVector(); // random existing car to compare below

        for (Car car : getCarsOnMapList()) {

            upRightVector = upRightVector.upperRight(car.getVector());
        }

        for (HayStack hayStack : hayStacksOnMap.values()) {

            upRightVector = upRightVector.upperRight(hayStack.getVector());
        }

        return upRightVector;
    }

    private Vector getDownLeftCorner() {

        Vector downLeftVector = getCarsOnMapList().get(0).getVector(); // random existing car to compare below

        for (Car car : getCarsOnMapList()) {

            downLeftVector = downLeftVector.lowerLeft(car.getVector());
        }

        for (HayStack hayStack : hayStacksOnMap.values()) {

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

        return hayStacksOnMap.get(vector) != null || super.isOccupied(vector);
    }

    @Override
    public Object objectAt(Vector vector) {

        if (hayStacksOnMap.get(vector) != null)
            return hayStacksOnMap.get(vector);

        else return super.objectAt(vector);
    }



}
