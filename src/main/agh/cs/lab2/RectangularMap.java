package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {

    private int height;
    private int width;

    public RectangularMap(int width, int height) {

        super();
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean canMoveTo(Vector vector) {

        if (!(vector.x > -1 && vector.x <= this.width && vector.y > -1 && vector.y <= this.height))
            return false;

        return super.canMoveTo(vector);
    }

    @Override
    public String toString() {

        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Vector(0, 0),new Vector(this.width, this.height));
    }
}
