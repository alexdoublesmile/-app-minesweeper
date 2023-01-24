package model.cell;

import model.Field;

import java.util.List;


public class ClosedEmptyCell extends Cell {
    public ClosedEmptyCell(int row, int column, CellType type, boolean isOpen) {
        super(row, column, type, isOpen);
    }

    @Override
    public void openCell(int row, int col, Field field) {
        field.makeOpen(row, col);

        field.getCells()[row][col].getAroundCells()
//                .stream()
//                .filter(Cell::isClosed)
                .forEach(cell -> cell.openCell(cell.getRow(), cell.getColumn(), field));
    }
}
