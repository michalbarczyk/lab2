package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {

    private List<Car> carsOnMap;
    private int height;
    private int width;

    public RectangularMap(int width, int height) {

        this.height = height;
        this.width = width;
        carsOnMap = new ArrayList<>();
    }

    public boolean canMoveTo(Vector vector) {

        if (!(vector.x > -1 && vector.x < this.width && vector.y > -1 && vector.y < this.height))
            return false;

        for (Car car : carsOnMap) {

            if (car.getVector().equals(vector))
                return false;
        }

        return true;
    }

    public boolean place(Car car) {
        if (this.canMoveTo(car.getVector())) {
            this.carsOnMap.add(car);
            return true;
        }
        else return false;

    }

    /**
     * Move the cars on the map according to the provided move directions. Every
     * n-th direction should be sent to the n-th car on the map.
     *
     * @param directions
     *            Array of move directions.
     */
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
       return false;
    }

    public Object objectAt(Vector vector) {

        for (Car car : carsOnMap) {
            if (car.getVector().equals(vector))
                return car;
        }

        return null;
    }

    @Override
    public String toString() {

        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Vector(0, 0),new Vector(this.width, this.height));
    }

    public Car getCarByIndex(int index) {

        return carsOnMap.get(index);
    }

}
