package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.cell.Cell;

import static model.GameState.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
