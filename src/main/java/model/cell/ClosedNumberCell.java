package model.cell;

import model.Field;

public class ClosedNumberCell extends Cell {

    public ClosedNumberCell(Cell cell) {
        this.row = cell.row;
        this.column = cell.column;
        this.type = CellType.NUMBER;
        this.isOpen = cell.isOpen;
        this.isFlagged = cell.isFlagged;
        this.isLosing = cell.isLosing;
        this.field = cell.field;
        addAroundCells(cell.aroundCells);
    }

    @Override
    public void openCell(int row, int col, Field field) {
        field.makeOpen(row, col, false);
    }
}
