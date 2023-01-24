package model.cell;

import model.Field;

import java.util.List;

public class OpenCell extends Cell {

    public OpenCell(Cell cell) {
        this.row = cell.row;
        this.column = cell.column;
        this.type = cell.type;
        this.isOpen = true;
        this.isFlagged = cell.isFlagged;
        this.isLosing = cell.isLosing;
        this.field = cell.field;
        addAroundCells(cell.aroundCells);
    }

    @Override
    public void openCell(int row, int col, Field field) {
        // TODO: 24.01.2023 no click action for open cells

        final Cell openCell = field.getCells()[row][col];

        final List<Cell> aroundCells = openCell.getAroundCells();
        final long flagsNumber = aroundCells.stream()
                .filter(Cell::isFlagged)
                .count();

        final long bombsNumber = aroundCells.stream()
                .filter(Cell::isBomb)
                .count();

        if (flagsNumber == bombsNumber) {
            aroundCells.stream()
                    .filter(Cell::isNotFlagged)
                    .forEach(cell -> field.makeOpen(cell.getRow(), cell.getColumn()));
        }
    }
}
