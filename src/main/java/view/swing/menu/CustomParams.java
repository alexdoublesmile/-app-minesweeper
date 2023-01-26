package view.swing.menu;

public class CustomParams {
    private final static int MIN_ROWS_NUMBER = 3;
    private final static int MAX_ROWS_NUMBER = 19;
    private final static int MIN_COLUMNS_NUMBER = 3;
    private final static int MAX_COLUMNS_NUMBER = 38;
    private final static int MIN_BOMBS_NUMBER = 1;
    
    private final int rows;
    private final int columns;
    private final int bombs;

    private CustomParams(int rows, int columns, int bombs) {
        this.rows = rows;
        this.columns = columns;
        this.bombs = bombs;
    }

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

    public static CustomParamsBuilder builder() {
        return new CustomParamsBuilder();
    }

    public static class CustomParamsBuilder {
        private int rows;
        private int columns;
        private int bombs;

        public CustomParamsBuilder rows(int rows) {
            this.rows = rows;
            return this;
        }

        public CustomParamsBuilder columns(int columns) {
            this.columns = columns;
            return this;
        }

        public CustomParamsBuilder bombs(int bombs) {
            this.bombs = bombs;
            return this;
        }

        public CustomParams build() {
            return new CustomParams(rows, columns, bombs);
        }
    }
}
