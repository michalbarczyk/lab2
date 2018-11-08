package agh.cs.lab2;

enum MapDirection {
    NORTH, SOUTH, WEST, EAST;

    public String toString() {

        switch (this) {

            case NORTH:
                return "N";

            case SOUTH:
                return "S";

            case WEST:
                return "W";

            case EAST:
                return "E";
        }

        return "";
    }

    public MapDirection next() {

        switch (this) {

            case NORTH:
                return EAST;

            case SOUTH:
                return WEST;

            case WEST:
                return NORTH;

            case EAST:
                return SOUTH;
        }
        return null;
    }

    public MapDirection prev() {

        switch (this) {

            case NORTH:
                return WEST;

            case SOUTH:
                return EAST;

            case WEST:
                return SOUTH;

            case EAST:
                return NORTH;
        }
        return null;
    }

}
