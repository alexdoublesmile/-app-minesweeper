package alt.service;

import alt.config.GameSettings;
import alt.model.Cell;
import alt.model.CellType;
import alt.model.Field;
import alt.util.FieldUtil;

public final class FieldService {

    private final CellService cellService;

    public FieldService(CellService cellService) {
        this.cellService = cellService;
    }

    public Field initEmptyCells(GameSettings settings) {
        Cell[][] cells = new Cell[settings.getNumberOfRows()][settings.getNumberOfColumns()];

        for (int row = 0; row < settings.getNumberOfRows(); row++) {
            for (int column = 0; column < settings.getNumberOfColumns(); column++) {
                cells[row][column] = Cell.builder()
                        .row(row)
                        .column(column)
                        .size(settings.getCellSize())
                        .type(CellType.EMPTY)
                        .build();
            }
        }
        return Field.builder()
                .numberOfRows(settings.getNumberOfRows())
                .numberOfColumns(settings.getNumberOfColumns())
                .activeBombsNumber(settings.getNumberOfBombs())
                .cells(cells)
                .build();
    }

    public Field addCellsAround(Field field) {
        final Cell[][] cells = field.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[row].length; column++) {
                final Cell currentCell = cells[row][column];

                currentCell.setAroundCells(cellService.addCellsAround(currentCell, cells));
            }
        }
        return field;
    }

    public Field addBombs(Field field) {
        for (int i = 0; i < field.getActiveBombsNumber(); i++) {

            Cell randomCell = FieldUtil.getNoBombRandomCell(field);

            field.getCells()[randomCell.getRow()][randomCell.getColumn()].setType(CellType.BOMB);
        }
        return field;
    }

    // TODO: 21.01.2023 add numbers
}
