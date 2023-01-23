package util;

import config.GameSettings;
import model.Cell;
import model.CellType;
import model.Field;

public final class FieldFactory {
    private static final FieldFactory INSTANCE = new FieldFactory();
    private GameSettings settings;

    private FieldFactory() {
    }

    private Field field;

    public FieldFactory initEmptyField() {
        final int rowsNumber = settings.getNumberOfRows();
        final int columnsNumber = settings.getNumberOfColumns();
        Cell[][] cells = new Cell[rowsNumber][columnsNumber];

        for (int row = 0; row < rowsNumber; row++) {
            for (int column = 0; column < columnsNumber; column++) {
                cells[row][column] = Cell.builder()
                        .row(row)
                        .column(column)
                        .type(CellType.EMPTY)
                        .build();
            }
        }
        field = Field.builder()
                .numberOfRows(rowsNumber)
                .numberOfColumns(columnsNumber)
                .activeBombsNumber(settings.getNumberOfBombs())
                .cells(cells)
                .cellSize(settings.getCellSize())
                .closedCellsNumber(rowsNumber * columnsNumber)
                .build();

        return this;
    }

    public FieldFactory addCellsAround() {
        final Cell[][] cells = field.getCells();
        for (int row = 0; row < field.getNumberOfRows(); row++) {
            for (int column = 0; column < field.getNumberOfColumns(); column++) {
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

    public FieldFactory addBombs() {
        for (int i = 0; i < field.getActiveBombsNumber(); i++) {

            Cell randomCell = CellUtil.getNoBombRandomCell(field);

            field.getCells()[randomCell.getRow()][randomCell.getColumn()].makeBomb();
        }
        return this;
    }

    public FieldFactory addNumbers() {
        final Cell[][] cells = field.getCells();
        for (int row = 0; row < field.getNumberOfRows(); row++) {
            for (int column = 0; column < field.getNumberOfColumns(); column++) {
                final Cell currentCell = cells[row][column];

                if (CellType.BOMB == currentCell.getType()) {
                    currentCell.getAroundCells()
                            .stream()
                            .filter(cell -> CellType.BOMB != cell.getType())
                            .forEach(cell -> cell.makeNumber());
                }
            }
        }
        return this;
    }

    public Field buildField() {
        return field;
    }

    public static FieldFactory withSettings(GameSettings settings) {
        return INSTANCE.getInstanceWithSettings(settings);
    }

    private FieldFactory getInstanceWithSettings(GameSettings settings) {
        this.settings = settings;
        return this;
    }
}
