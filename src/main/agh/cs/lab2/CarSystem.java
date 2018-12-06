package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class CarSystem {

    public static void main(String[] args) {

        try {

            MoveDirection[] directions = OptionsParser.parse(new String[]{"f","f","f","f","r","f","l","f","f","f","f"});
            List<HayStack> hayStacks = new ArrayList<>();
            hayStacks.add(new HayStack(new Vector(0, 0)));
            hayStacks.add(new HayStack(new Vector(7, 7)));
            hayStacks.add(new HayStack(new Vector(2, 6)));
            hayStacks.add(new HayStack(new Vector(-3, -3)));


            IWorldMap map = new UnboundedMap(hayStacks);
            map.place(new Car(map));
            map.run(directions);
            //map.place(new Car(map, new Vector(3,9))); //already occupied vector
            System.out.println(map);

        } catch (IllegalArgumentException e) {

            e.printStackTrace();
        }




    }
}
