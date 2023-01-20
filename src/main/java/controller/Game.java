package controller;

import model.Box;
import model.Coord;
import model.Matrix;
import util.Ranges;

import java.awt.*;

public class Game {
    private Matrix bombMap;

    public Game(int cols, int rows) {
        Ranges.setSize(new Coord(cols, rows));
    }

    public void start() {
        bombMap = new Matrix(Box.ZERO);
    }

    public Box getBox(Coord coord) {
        return bombMap.get(coord);
    }
}
