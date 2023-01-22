package alt.util;

import alt.config.GameSettings;
import alt.model.Cell;
import alt.model.CellType;
import alt.model.Field;

import java.util.ArrayList;
import java.util.List;

public final class FieldFactory {
    private static final FieldFactory INSTANCE = new FieldFactory();
    private GameSettings settings;

    private FieldFactory() {
    }

    private Field field;

    public FieldFactory initEmptyField() {
        Cell[][] cells = new Cell[settings.getNumberOfRows()][settings.getNumberOfColumns()];

        for (int row = 0; row < settings.getNumberOfRows(); row++) {
            for (int column = 0; column < settings.getNumberOfColumns(); column++) {
                cells[row][column] = Cell.builder()
                        .row(row)
                        .column(column)
                        .type(CellType.EMPTY)
                        .isOpen(true)
                        .build();
            }
        }
        field = Field.builder()
                .numberOfRows(settings.getNumberOfRows())
                .numberOfColumns(settings.getNumberOfColumns())
                .activeBombsNumber(settings.getNumberOfBombs())
                .cells(cells)
                .cellSize(settings.getCellSize())
                .build();

        return this;
    }

    public FieldFactory addCellsAround() {
        final Cell[][] cells = field.getCells();
        for (int row = 0; row < field.getNumberOfRows(); row++) {
            for (int column = 0; column < field.getNumberOfColumns(); column++) {
                final Cell currentCell = cells[row][column];

                currentCell.setAroundCells(addCellsAround(currentCell));
            }
        }
        return this;
    }

    private List<Cell> addCellsAround(Cell currentCell) {
        List<Cell> aroundCells = new ArrayList<>();

        for (int row = currentCell.getRow() - 1; row <= currentCell.getRow() + 1; row++) {
            for (int column = currentCell.getColumn() - 1; column <= currentCell.getColumn() + 1; column++) {


                if (CellUtil.isValidCoords(row, column, field)) {

                    final Cell aroundCell = field.getCells()[row][column];
                    if (!aroundCell.equals(currentCell)) {
                        aroundCells.add(aroundCell);
                    }
                }
            }
        }
        return aroundCells;
    }

    public FieldFactory addBombs() {
        for (int i = 0; i < field.getActiveBombsNumber(); i++) {

            Cell randomCell = CellUtil.getNoBombRandomCell(field);

            field.getCells()[randomCell.getRow()][randomCell.getColumn()].setType(CellType.BOMB);
        }
        return this;
    }

    public FieldFactory addNumbers() {
        final Cell[][] cells = field.getCells();
        for (int row = 0; row < field.getNumberOfRows(); row++) {
            for (int column = 0; column < field.getNumberOfColumns(); column++) {
                final Cell currentCell = cells[row][column];

                if (CellType.BOMB == currentCell.getType()) {
                    currentCell.getAroundCells().forEach(cell -> cell.setType(CellType.NUMBER));
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
