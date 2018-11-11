package agh.cs.lab2;

public class CarSystem {

    public static void main(String[] args) {

        IWorldMap carMap = new RectangularMap(5,5);


        Car myCar = new Car();

        carMap.place()

        MoveDirection[] moveTable = OptionsParser.parse(new String[] {"f", "f","l","f","r"});
        for (MoveDirection moveDirection : moveTable) {

            myCar.move(moveDirection);
            System.out.println(myCar.toString());
        }



    }
}
