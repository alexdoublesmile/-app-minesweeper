package model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import model.cell.Cell;

@Data
public class Game {
    private Field field;
    private GameState state;

    public void makeLosing(Cell cell) {
        state = GameState.LOSING;
        cell.makeLosing();
    }

    public void makeWinning() {
        state = GameState.WINNING;
    }

    public Cell getCell(int row, int col) {
        return getField().getCells()[row][col];
    }

    public boolean isOver() {
        return getField().getClosedCellsNumber() == getField().getActiveBombsNumber();
    }

    public void setField(Field field) {
        this.field = field;
        field.setGame(this);
    }

    public void setState(GameState state) {
        this.state = state;
    }
}
