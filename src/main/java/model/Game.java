package model;

import model.cell.Cell;

import static model.GameState.*;

public class Game {
    private Field field;
    private GameState state;

    public Game(Field field, GameState state) {
        this.field = field;
        this.state = state;
    }

    public Game() {
    }

    public Cell getCell(int row, int col) {
        return getField().getCells()[row][col];
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void setWinIfNeeds() {
        if (areBombsFounded() && state == PLAYING) {
            state = WINNING;
        }
    }

    public boolean areBombsFounded() {
        return getField().getClosedCellsNumber() == getField().getBombsNumber();
    }

    public boolean isOver() {
        return WINNING == state || LOSING == state;
    }

    public boolean isNotInitialized() {
        return NOT_INITIALIZED == state;
    }

    public Field getField() {
        return field;
    }

    public GameState getState() {
        return state;
    }
}
