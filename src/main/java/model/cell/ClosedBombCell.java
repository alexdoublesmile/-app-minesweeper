package model.cell;

import model.Field;
import util.CellUtil;

public class ClosedBombCell extends Cell {

    public ClosedBombCell(Cell emptyCell) {
        this.row = emptyCell.row;
        this.column = emptyCell.column;
        this.type = CellType.BOMB;
        this.isOpen = emptyCell.isOpen;
        this.field = emptyCell.field;
    }

    @Override
    public void openCell(int row, int col, Field field) {
        field.makeLosing(row, col);

        CellUtil.getCellList(field.getCells()).stream()
                .filter(cell -> cell.isBomb() && !cell.isFlagged() || cell.isFlagged() && !cell.isBomb())
                .forEach(cell -> field.makeOpen(cell.row, cell.column));
    }
}
