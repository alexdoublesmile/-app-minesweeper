package alt.service;

import alt.config.GameSettings;
import alt.model.Cell;
import alt.model.CellType;

public final class FieldService {

    private final CellService cellService;

    public FieldService(CellService cellService) {
        this.cellService = cellService;
    }

    public Cell[][] initEmptyCells(GameSettings settings) {
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
        return cells;
    }

    public Cell[][] addCellsAround(Cell[][] cells) {
        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[row].length; column++) {
                final Cell currentCell = cells[row][column];

                currentCell.setAroundCells(cellService.addCellsAround(currentCell, cells));
            }
        }
        return cells;
    }

    // TODO: 21.01.2023 add bombs
    // TODO: 21.01.2023 add numbers
}
