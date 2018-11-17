package agh.cs.lab2;

public class HayStack implements IMapElement {

    private Vector hayStackVector;

    HayStack(Vector hayStackVector) {

        this.hayStackVector = hayStackVector;
    }

    public Vector getVector() {

        return this.hayStackVector;
    }

    @Override
    public String toString() {

        return "s";
    }
}
