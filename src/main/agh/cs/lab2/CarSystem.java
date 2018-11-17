package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class CarSystem {

    public static void main(String[] args) {

        MoveDirection[] directions = OptionsParser.parse(new String[]{"f","f","r","l","r","l","f","f","l","r"});
        List<HayStack> hayStacks = new ArrayList<>();
        hayStacks.add(new HayStack(new Vector(-4, -4)));
        hayStacks.add(new HayStack(new Vector(7, 7)));
        hayStacks.add(new HayStack(new Vector(3, 6)));
        hayStacks.add(new HayStack(new Vector(2, 0)));

        hayStacks.add(new HayStack(new Vector(-15, -9)));
        hayStacks.add(new HayStack(new Vector(20, 23)));


        IWorldMap map = new UnboundedMap(hayStacks);
        map.place(new Car(map));
        map.place(new Car(map, new Vector(3,4)));
        map.run(directions);
        System.out.println(map);
    }
}
