package agh.cs.lab2;

public class OptionsParser {

    public MoveDirection[] parse(String[] initials) {

        MoveDirection[] directionTable = new MoveDirection[initials.length];

        for(int i = 0; i < initials.length; i++) {

            switch(initials[i]) {

                case "f":
                    directionTable[i] = MoveDirection.FORWARD;
                    break;
                case "b":
                    directionTable[i] = MoveDirection.BACKWARD;
                    break;
                case "l":
                    directionTable[i] = MoveDirection.LEFT;
                    break;
                case "r":
                    directionTable[i] = MoveDirection.RIGHT;
                    break;
            }
        }

        return directionTable;
    }
}
