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
        if (gameOver()) {
            return;
        }
        openBox(coord);
        checkWinner();
    }

    private void checkWinner() {
        if (state == GameState.PLAYED) {
            if (flag.getCountOfClosedBoxes() == bomb.getTotalBombs()) {
                state = GameState.WINNER;
            }
        }
    }

    private void openBox(Coord coord) {
        switch (flag.get(coord)) {
            case OPENED: return;
            case FLAGGED: return;
            case CLOSED:
                switch (bomb.get(coord)) {
                    case ZERO: openBoxesAround(coord);
                    case BOMB: openBombs(coord);
                    default: flag.setOpenedToBox(coord);
                }
        }
    }

    private void openBombs(Coord bombed) {
        state = GameState.BOMBED;
        flag.setBombToBox(bombed);
        for (Coord coord : Ranges.getAllCoords()) {
            if (bomb.get(coord) == Box.BOMB) {
                flag.setOpenedToClosedBombBox(coord);
            } else {
                flag.setNoBombToFlaggedSafeBox(coord);
            }
        }
    }

    private void openBoxesAround(Coord coord) {
        flag.setOpenedToBox(coord);
        for (Coord aroundCoord : Ranges.getCoordsAround(coord)) {
            openBox(aroundCoord);
        }
    }

    public void pressRightButton(Coord coord) {
        if (gameOver()) {
            return;
        }
        flag.toggleFlaggedToBox(coord);
    }

    private boolean gameOver() {
        if (state == GameState.PLAYED) {
            return false;
        }
        start();
        return true;
    }

    public GameState getState() {
        return state;
    }
}
