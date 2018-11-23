package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class CarSystem {

    public static void main(String[] args) {

        try {

            MoveDirection[] directions = OptionsParser.parse(new String[]{"f","f","r","l"});
            List<HayStack> hayStacks = new ArrayList<>();
            hayStacks.add(new HayStack(new Vector(0, 0)));
            hayStacks.add(new HayStack(new Vector(7, 7)));
            hayStacks.add(new HayStack(new Vector(3, 6)));
            hayStacks.add(new HayStack(new Vector(2, 0)));


            IWorldMap map = new UnboundedMap(hayStacks);
            map.place(new Car(map));
            map.place(new Car(map, new Vector(3,4)));
            map.run(directions);

            //map.place(new Car(map, new Vector(2,3)));
            System.out.println(map);


        } catch (IllegalArgumentException e) {

            e.printStackTrace();
        }




    }
}
