package alfaversion.model;

import alfaversion.util.Ranges;

public class Matrix {
    private Box[][] matrix;

    public Matrix(Box defaultBox) {
        matrix = new Box[Ranges.getSize().getX()][Ranges.getSize().getY()];
        for (Coord coord : Ranges.getAllCoords()) {
            matrix[coord.getX()][coord.getY()] = defaultBox;
        }
    }

    public Box get(Coord coord) {
        if (Ranges.inRange(coord)) {
            return matrix[coord.getX()][coord.getY()];
        }
        return null;
    }

    public void set(Coord coord, Box box) {
        if (Ranges.inRange(coord)) {
            matrix[coord.getX()][coord.getY()] = box;
        }
    }
}
