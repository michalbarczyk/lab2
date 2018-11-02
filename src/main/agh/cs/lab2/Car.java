package agh.cs.lab2;

public class  Car {

    private MapDirection carDirection;
    private Vector carVector;

    public Car() {

        this.carVector = new Vector(2, 2);
        this.carDirection = MapDirection.NORTH;
    }

    public Car(int initX, int initY, MapDirection initDirection) {

        this.carVector = new Vector(initX, initY);
        this.carDirection = initDirection;
    }

    public String toString() {

        return ("Position: " + carVector.toString() + " Direction: " + carDirection.toString());
    }

    public Vector getCarVector() {
        return this.carVector;
    }

    public MapDirection getCarDirection() {
        return this.carDirection;
    }

    public void move(MoveDirection direction) {

        Vector candidateVector;

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
                        if (candidateVector.ifOnMap())
                            this.carVector = candidateVector;
                        break;
                    case SOUTH:
                        candidateVector = this.carVector.add(new Vector(0, -1));
                        if (candidateVector.ifOnMap())
                            this.carVector = candidateVector;
                        break;
                    case WEST:
                        candidateVector = this.carVector.add(new Vector(-1, 0));
                        if (candidateVector.ifOnMap())
                            this.carVector = candidateVector;
                        break;
                    case EAST:
                        candidateVector = this.carVector.add(new Vector(1, 0));
                        if (candidateVector.ifOnMap())
                            this.carVector = candidateVector;
                        break;
                }
                break;
            case BACKWARD:
                switch(carDirection) {

                    case NORTH:
                        candidateVector = this.carVector.add(new Vector(0, -1));
                        if (candidateVector.ifOnMap())
                            this.carVector = candidateVector;
                        break;
                    case SOUTH:
                        candidateVector = this.carVector.add(new Vector(0, 1));
                        if (candidateVector.ifOnMap())
                            this.carVector = candidateVector;
                        break;
                    case WEST:
                        candidateVector = this.carVector.add(new Vector(1, 0));
                        if (candidateVector.ifOnMap())
                            this.carVector = candidateVector;
                        break;
                    case EAST:
                        candidateVector = this.carVector.add(new Vector(-1, 0));
                        if (candidateVector.ifOnMap())
                            this.carVector = candidateVector;
                        break;
                }
                break;

        }
    }
}
