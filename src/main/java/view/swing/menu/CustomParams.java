package view.swing.menu;

import lombok.Builder;

@Builder
public class CustomParams {
    private final static int MIN_ROWS_NUMBER = 3;
    private final static int MAX_ROWS_NUMBER = 19;
    private final static int MIN_COLUMNS_NUMBER = 3;
    private final static int MAX_COLUMNS_NUMBER = 38;
    private final static int MIN_BOMBS_NUMBER = 1;
    
    private final int rows;
    private final int columns;
    private final int bombs;

    public int normalizedRows() {
        if (rows < MIN_ROWS_NUMBER) {
            return MIN_ROWS_NUMBER;
        }
        return Math.min(rows, MAX_ROWS_NUMBER);
    }

    public int normalizedColumns() {
        if (columns < MIN_COLUMNS_NUMBER) {
            return MIN_COLUMNS_NUMBER;
        }
        return Math.min(columns, MAX_COLUMNS_NUMBER);
    }

    public int normalizedBombs() {
        if (bombs < MIN_BOMBS_NUMBER) {
            return MIN_BOMBS_NUMBER;
        }
        return Math.min(bombs, normalizedRows() * normalizedColumns() - 2);
    }
}
