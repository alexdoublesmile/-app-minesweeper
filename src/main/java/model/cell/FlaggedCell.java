package model.cell;

import model.Field;

public class FlaggedCell extends Cell {

    public FlaggedCell(Cell cell) {
        this.row = cell.row;
        this.column = cell.column;
        this.type = cell.type;
        this.isOpen = cell.isOpen;
        this.isFlagged = !cell.isFlagged;
        this.isLosing = cell.isLosing;
        this.field = cell.field;
        addAroundCells(cell.aroundCells);
    }

    @Override
    public void openCell(int row, int col, Field field) {
        // no click action for flagged cells
    }
}
