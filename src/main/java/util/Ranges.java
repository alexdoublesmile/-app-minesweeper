package util;

import model.Coord;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ranges {
    private static Coord size;
    private static List<Coord> allCoords;
    private static Random random = new Random();

    public static Coord getSize() {
        return size;
    }

    public static void setSize(Coord size) {
        Ranges.size = size;
        allCoords = new ArrayList<>();

        for (int y = 0; y < size.getY(); y++) {
            for (int x = 0; x < size.getX(); x++) {
                allCoords.add(new Coord(x, y));
            }
        }
    }

    public static List<Coord> getAllCoords() {
        return allCoords;
    }

    public static boolean inRange(Coord coord) {
//        return coord.getX() >= 0 && coord.getX() < size.getX()
//                && coord.getY() >= 0 && coord.getY() < size.getY();
        return allCoords.contains(coord);
    }

    public static Coord getRandomCoord() {
        return new Coord(random.nextInt(size.getX()), random.nextInt(size.getY()));
    }
}
