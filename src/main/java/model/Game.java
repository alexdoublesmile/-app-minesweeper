package model;

import lombok.Data;
import model.cell.Cell;

import static model.GameState.PLAYING;
import static model.GameState.WINNING;

@Data
public class Game {
    private Field field;
    private GameState state;

    public Cell getCell(int row, int col) {
        return getField().getCells()[row][col];
    }

    public void setField(Field field) {
        this.field = field;
        field.setGame(this);
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void setWinIfNeeds() {
        if (isOver() && state == PLAYING) {
            state = WINNING;
        }
    }

    public boolean isOver() {
        return getField().getClosedCellsNumber() == getField().getBombsNumber();
    }
}
