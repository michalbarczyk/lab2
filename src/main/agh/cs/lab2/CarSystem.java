package agh.cs.lab2;

public class CarSystem {

    public static void main(String[] args) {

        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(8, 5);
        //map.place(new Car(map));
        map.place(new Car(map, new Vector(1,4)));
        //map.run(directions);
        System.out.println(map);
    }
}
