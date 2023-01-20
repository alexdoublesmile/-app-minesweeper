package controller;

import model.*;
import util.Ranges;

import java.awt.*;

public class Game {
    private Bomb bomb;
    private Flag flag;
    private GameState state;

    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
    }

    public void start() {
        bomb.start();
        flag.start();
        state = GameState.PLAYED;
    }

    public Box getBox(Coord coord) {
        return Box.OPENED == flag.get(coord) ? bomb.get(coord) : flag.get(coord);
    }

    public void pressLeftButton(Coord coord) {
        openBox(coord);

    }

    private void openBox(Coord coord) {
        switch (flag.get(coord)) {
            case OPENED: return;
            case FLAGGED: return;
            case CLOSED:
                switch (bomb.get(coord)) {
                    case ZERO: return;
                    case BOMB: return;
                    default: flag.setOpenedToBox(coord);
                }
        }
    }

    public void pressRightButton(Coord coord) {
        flag.toggleFlaggedToBox(coord);
    }

    public GameState getState() {
        return state;
    }
}
