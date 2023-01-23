package exception;

import model.Cell;

public class IncorrectCellTypeException extends RuntimeException {
    private Cell incorrectCell;
    public IncorrectCellTypeException(Cell cell) {
        incorrectCell = cell;
    }
}
