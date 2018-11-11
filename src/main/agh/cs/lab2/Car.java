package agh.cs.lab2;

public class Car {

    private MapDirection carDirection;
    private Vector carVector;
    private IWorldMap carMap;

    /*private Car(Vector initVector) {
        this.carVector = initVector;
        this.carDirection = MapDirection.NORTH;
    }*/


    public Car(IWorldMap map) {

        this.carVector = new Vector(2,2);
        this.carDirection = MapDirection.NORTH;
        this.carMap = map;

        this.carMap.place(this);
    }

    public Car(IWorldMap map, Vector initVector) {

        this.carVector = initVector;
        this.carDirection = MapDirection.NORTH;
        map.place(this);
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

    public void move(MoveDirection direction) {

        Vector candidateVector = null;

        switch(direction) {

            case LEFT:
                this.carDirection = carDirection.prev();
                break;
            case RIGHT:
                this.carDirection = carDirection.next();
                break;
            case FORWARD:
                switch(carDirection) {

                    case NORTH:
                        candidateVector = this.carVector.add(new Vector(0, 1));
                        break;
                    case SOUTH:
                        candidateVector = this.carVector.add(new Vector(0, -1));
                        break;
                    case WEST:
                        candidateVector = this.carVector.add(new Vector(-1, 0));
                        break;
                    case EAST:
                        candidateVector = this.carVector.add(new Vector(1, 0));
                        break;
                }
                if (this.carMap.canMoveTo(candidateVector))
                    this.carVector = candidateVector;
                break;

            case BACKWARD:
                switch(carDirection) {

                    case NORTH:
                        candidateVector = this.carVector.add(new Vector(0, -1));
                        break;
                    case SOUTH:
                        candidateVector = this.carVector.add(new Vector(0, 1));
                        break;
                    case WEST:
                        candidateVector = this.carVector.add(new Vector(1, 0));
                        break;
                    case EAST:
                        candidateVector = this.carVector.add(new Vector(-1, 0));
                        break;
                }
                if (this.carMap.canMoveTo(candidateVector))
                    this.carVector = candidateVector;
                break;
        }


    }
}
