package agh.cs.lab2;

public class Car {

    private MapDirection carDirection;
    private Vector carVector;

    /*private Car(Vector initVector) {
        this.carVector = initVector;
        this.carDirection = MapDirection.NORTH;
    }*/


    /*public Car(IWorldMap map) {

        Car newCar = new Car(new Vector(2, 2));

        map.place(newCar);

    }*/

    public Car(IWorldMap map, Vector initVector) {

        this.carVector = initVector;
        this.carDirection = MapDirection.NORTH;

    }

    public String toString() {

        return carDirection.toString();
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
                        //if (candidateVector.ifOnMap())
                            this.carVector = candidateVector;
                        break;
                    case SOUTH:
                        candidateVector = this.carVector.add(new Vector(0, -1));
                        //if (candidateVector.ifOnMap())
                            this.carVector = candidateVector;
                        break;
                    case WEST:
                        candidateVector = this.carVector.add(new Vector(-1, 0));
                        //if (candidateVector.ifOnMap())
                            this.carVector = candidateVector;
                        break;
                    case EAST:
                        candidateVector = this.carVector.add(new Vector(1, 0));
                        //if (candidateVector.ifOnMap())
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
