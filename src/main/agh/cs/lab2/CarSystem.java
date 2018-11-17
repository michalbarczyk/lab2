package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class CarSystem {

    public static void main(String[] args) {

        MoveDirection[] directions = OptionsParser.parse(args);
        List<HayStack> hayStacks = new ArrayList<>();
        hayStacks.add(new HayStack(new Vector(-4, -4)));
        hayStacks.add(new HayStack(new Vector(7, 7)));
        hayStacks.add(new HayStack(new Vector(3, 6)));
        hayStacks.add(new HayStack(new Vector(2, 0)));


        IWorldMap map = new UnboundedMap(hayStacks);
        map.place(new Car(map));
        map.place(new Car(map, new Vector(3,4)));
        map.run(directions);
        System.out.println(map);
    }
}
