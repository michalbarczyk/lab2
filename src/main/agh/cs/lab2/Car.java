package agh.cs.lab2;

public class Car {

    private MapDirection carDirection = MapDirection.NORTH;
    private Vector carVector = new Vector(2, 2);

    public String toString() {

        return ("Position: " + carVector.toString() + " Direction: " + carDirection.toString());
    }

    private boolean checkIfPossible (Vector candidateVector) {

        return (candidateVector.x > -1 && candidateVector.x < 5 && candidateVector.y > -1 && candidateVector.y < 5);
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
                        if (checkIfPossible(candidateVector))
                            this.carVector = candidateVector;
                        break;
                    case SOUTH:
                        candidateVector = this.carVector.add(new Vector(0, -1));
                        if (checkIfPossible(candidateVector))
                            this.carVector = candidateVector;
                        break;
                    case WEST:
                        candidateVector = this.carVector.add(new Vector(-1, 0));
                        if (checkIfPossible(candidateVector))
                            this.carVector = candidateVector;
                        break;
                    case EAST:
                        candidateVector = this.carVector.add(new Vector(1, 0));
                        if (checkIfPossible(candidateVector))
                            this.carVector = candidateVector;
                        break;
                }
                break;
            case BACKWARD:
                switch(carDirection) {

                    case NORTH:
                        candidateVector = this.carVector.add(new Vector(0, -1));
                        if (checkIfPossible(candidateVector))
                            this.carVector = candidateVector;
                        break;
                    case SOUTH:
                        candidateVector = this.carVector.add(new Vector(0, 1));
                        if (checkIfPossible(candidateVector))
                            this.carVector = candidateVector;
                        break;
                    case WEST:
                        candidateVector = this.carVector.add(new Vector(1, 0));
                        if (checkIfPossible(candidateVector))
                            this.carVector = candidateVector;
                        break;
                    case EAST:
                        candidateVector = this.carVector.add(new Vector(-1, 0));
                        if (checkIfPossible(candidateVector))
                            this.carVector = candidateVector;
                        break;
                }
                break;

        }
    }
}
