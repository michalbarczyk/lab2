package agh.cs.lab2;

public class Vector {

    public final int x;
    public final int y;

    public Vector(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {

        return "(" + x + ", " + y + ")";
    }

    public boolean smaller(Vector vector) {

        if (this.x <= vector.x && this.y <= vector.y) return true;
        else return false;
    }

    public boolean larger(Vector vector) {

        if (this.x >= vector.x && this.y >= vector.y) return true;
        else return false;
    }

    public Vector upperRight(Vector oldVector) {

        return new Vector( Math.max(this.x, oldVector.x),  Math.max(this.y, oldVector.y));
    }

    public Vector lowerLeft(Vector oldVector) {

        return new Vector( Math.min(this.x, oldVector.x),  Math.min(this.y, oldVector.y));
    }

    public Vector add(Vector oldVector) {

        return new Vector(oldVector.x + this.x, oldVector.y + this.y);
    }

    @Override
    public boolean equals(Object other) {

        if (this == other)
            return true;
        if (!(other instanceof Vector))
            return false;

        Vector that = (Vector) other;

        /*if (this.x == other.x && this.y == other.y)
            return true;
        else
            return false;
        */

        return (this.x == that.x && this.y == that.y);
    }

    protected boolean ifOnMap() {

        return (this.x > -1 && this.x < 5 && this.y > -1 && this.y < 5);
    }








}
