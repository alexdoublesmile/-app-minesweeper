package util;

import model.Coord;

import java.util.List;

public class Ranges {
    private static Coord size;
    private static List<Coord> allCoords;

    public static Coord getSize() {
        return size;
    }

    public static void setSize(Coord size) {
        Ranges.size = size;
    }
}
