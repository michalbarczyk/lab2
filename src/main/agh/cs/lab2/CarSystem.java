package agh.cs.lab2;

public class CarSystem {

    public static void main(String[] args) {

        Vector vector1 = new Vector(1,2);
        System.out.println(vector1);

        Vector vector2 = new Vector(-2,1);
        System.out.println(vector2);

        System.out.println(vector1.add(vector2));
    }
}
