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
        bombMap.set(new Coord(0, 0), Box.BOMB);
        bombMap.set(new Coord(0, 1), Box.NUM1);
        bombMap.set(new Coord(1, 0), Box.NUM1);
        bombMap.set(new Coord(1, 1), Box.NUM1);
    }

    public Box getBox(Coord coord) {
        return bombMap.get(coord);
    }
}
