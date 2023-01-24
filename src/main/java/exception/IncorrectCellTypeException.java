package exception;

import model.cell.Cell;

public class IncorrectCellTypeException extends RuntimeException {
    private Cell incorrectCell;
    public IncorrectCellTypeException(Cell cell) {
        incorrectCell = cell;
    }
}
