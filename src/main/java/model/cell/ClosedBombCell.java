package model.cell;

import model.Field;
import util.CellUtil;

public class ClosedBombCell extends Cell {
    public ClosedBombCell(Cell cell) {
        this.row = cell.row;
        this.column = cell.column;
        this.type = CellType.BOMB;
        this.isOpen = cell.isOpen;
        this.isFlagged = cell.isFlagged;
        this.isLosing = cell.isLosing;
        this.field = cell.field;
        addAroundCells(cell.aroundCells);
    }

    @Override
    public void openCell(int row, int col, Field field) {
        CellUtil.getCellList(field.getCells()).stream()
                .filter(cell -> cell.isBomb() && cell.isNotFlagged() || cell.isFlagged() && !cell.isBomb())
                .forEach(cell -> field.makeOpen(cell.row, cell.column, false));

        field.makeLosing(row, col);
    }
}
