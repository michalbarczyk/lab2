package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class Car implements IMapElement {

    private MapDirection carDirection;
    private Vector carVector;
    private IWorldMap carMap;
    private List<IPositionChangeObserver> positionChangeObservers;

    public Car(IWorldMap map) {

        this(map, Consts.DEFAULTCARVECTOR);
    }

    public Car(IWorldMap map, Vector initVector) {

        this.carVector = initVector;
        this.carDirection = Consts.DEFAULTCARDIRECTION;
        this.carMap = map;
        this.positionChangeObservers = new ArrayList<>();
    }

    public Vector getVector() {

        return this.carVector;
    }

    public String toString() {

        return carDirection.toString();
    }

    public MapDirection getDirection() {
        return this.carDirection;
    }

    private Vector getCandidateVector(MoveDirection direction) {

        Vector versor = null;

        switch (this.carDirection) {
            case NORTH:
                versor = new Vector(0,1);
                break;
            case SOUTH:
                versor = new Vector(0,-1);
                break;
            case EAST:
                versor = new Vector(1,0);
                break;
            case WEST:
                versor = new Vector(-1,0);
                break;
        }

        Vector candidateVector = null;

        switch (direction) {

            case FORWARD:
                candidateVector = this.carVector.add(versor);
                break;
            case BACKWARD:
                candidateVector = this.carVector.add(versor.getOpposite());
                break;
        }

        return candidateVector;
    }

    public void move(MoveDirection direction) {

        if (direction == MoveDirection.LEFT)
            this.carDirection = carDirection.prev();
        else if (direction == MoveDirection.RIGHT)
            this.carDirection = carDirection.next();
        else {
            Vector candidateVector = getCandidateVector(direction);
            if (this.carMap.canMoveTo(candidateVector)) {

                positionChanged(this.carVector, candidateVector);
                this.carVector = candidateVector;

            }

        }
    }

    public void addObserver(IPositionChangeObserver observer) {

        positionChangeObservers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {

        positionChangeObservers.remove(observer);
    }

    public void positionChanged(Vector oldVector, Vector newVector) {

        for (IPositionChangeObserver observer : positionChangeObservers) {

            observer.positionChanged(oldVector, newVector);
        }
    }
}
