package util;

import config.GameSettings;
import model.cell.*;
import model.Field;

public final class FieldFactory {
    private static final FieldFactory INSTANCE = new FieldFactory();

    private GameSettings settings;
    private Field field;

    public FieldFactory initEmptyField() {
        final int rowsNumber = settings.getNumberOfRows();
        final int columnsNumber = settings.getNumberOfColumns();
        Cell[][] cells = new Cell[rowsNumber][columnsNumber];

        for (int row = 0; row < rowsNumber; row++) {
            for (int column = 0; column < columnsNumber; column++) {
                cells[row][column] = new ClosedEmptyCell(row, column);
            }
        }
        field = Field.builder()
                .rowsNumber(rowsNumber)
                .columnsNumber(columnsNumber)
                .bombsNumber(settings.getNumberOfBombs())
                .cells(cells)
                .cellSize(settings.getCellSize())
                .closedCellsNumber(rowsNumber * columnsNumber)
                .build();

        return this;
    }

    public FieldFactory addBombs(int row, int column) {
        for (int i = 0; i < field.getBombsNumber(); i++) {

            Cell randomCell = CellUtil.getNoBombRandomCell(field, row, column);

            final Cell emptyCell = field.getCells()[randomCell.getRow()][randomCell.getColumn()];
            field.getCells()[randomCell.getRow()][randomCell.getColumn()] = new ClosedBombCell(emptyCell);
        }
        return this;
    }

    public FieldFactory addCellsAround() {
        final Cell[][] cells = field.getCells();
        for (int row = 0; row < field.getRowsNumber(); row++) {
            for (int column = 0; column < field.getColumnsNumber(); column++) {
                final Cell currentCell = cells[row][column];

                addCellsAround(currentCell);
            }
        }
        return this;
    }

    private void addCellsAround(Cell currentCell) {
        for (int row = currentCell.getRow() - 1; row <= currentCell.getRow() + 1; row++) {
            for (int column = currentCell.getColumn() - 1; column <= currentCell.getColumn() + 1; column++) {


                if (CellUtil.isValidCoords(row, column, field)) {

                    final Cell aroundCell = field.getCells()[row][column];
                    if (!aroundCell.equals(currentCell)) {
                        currentCell.addAroundCell(aroundCell);
                    }
                }
            }
        }
    }

    public FieldFactory addNumbers() {
        final Cell[][] cells = field.getCells();
        for (int row = 0; row < field.getRowsNumber(); row++) {
            for (int column = 0; column < field.getColumnsNumber(); column++) {
                final Cell currentCell = cells[row][column];

                if (currentCell.isBomb()) {
                    currentCell.getAroundCells()
                            .stream()
                            .filter(cell -> !cell.isBomb())
                            .forEach(cell -> field.getCells()[cell.getRow()][cell.getColumn()] = new ClosedNumberCell(cell));
                }
            }
        }
        return this;
    }

    public Field build() {
        return field;
    }

    public static FieldFactory withSettings(GameSettings settings) {
        return INSTANCE.getInstanceWithSettings(settings);
    }

    private FieldFactory getInstanceWithSettings(GameSettings settings) {
        this.settings = settings;
        return this;
    }

    public static FieldFactory started() {
        return INSTANCE.getInstanceWithField();
    }

    private FieldFactory getInstanceWithField() {
        return this;
    }
}
