package agh.cs.lab2;

public class CarSystem {

    public static void main(String[] args) {

        /*
        Car car = new Car();
        System.out.println(car.toString());
        car.move(MoveDirection.RIGHT);
        car.move(MoveDirection.FORWARD);
        car.move(MoveDirection.FORWARD);
        car.move(MoveDirection.FORWARD);
        System.out.println(car.toString());
        */

        Car myCar = new Car();

        MoveDirection[] moveTable = OptionsParser.parse(new String[] {"f", "f","l","f","r"});
        for (MoveDirection moveDirection : moveTable) {

            myCar.move(moveDirection);
            System.out.println(myCar.toString());
        }



    }
}
