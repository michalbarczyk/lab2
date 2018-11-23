package agh.cs.lab2;

public class OptionsParser {

    public static MoveDirection[] parse(String[] initials) throws IllegalArgumentException {

        int directionTableSize = 0;

        for (String initial : initials) {

            if (initial.equals("f") || initial.equals("b") || initial.equals("r") || initial.equals("l"))
                directionTableSize++;
            else throw new IllegalArgumentException(initial + " is not legal move specification");
        }

        MoveDirection[] directionTable = new MoveDirection[directionTableSize];
        int j = 0; //j iterates on directionTable

        for (int i = 0; i < initials.length; i++) { //i iterates on initials

            switch(initials[i]) {

                case "f":
                    directionTable[j] = MoveDirection.FORWARD;
                    j++;
                    break;
                case "b":
                    directionTable[j] = MoveDirection.BACKWARD;
                    j++;
                    break;
                case "l":
                    directionTable[j] = MoveDirection.LEFT;
                    j++;
                    break;
                case "r":
                    directionTable[j] = MoveDirection.RIGHT;
                    j++;
                    break;
            }

            //DEBUG: System.out.println("i = " + i + ", j = " + j);
        }

        return directionTable;
    }
}
