package model;

import util.Ranges;

public class Matrix {
    private Box[][] matrix;

    public Matrix(Box defaultBox) {
        matrix = new Box[Ranges.getSize().getX()][Ranges.getSize().getY()];
        for (Coord coord : Ranges.getAllCoords()) {
            matrix[coord.getX()][coord.getY()] = defaultBox;
        }
    }

    
}
