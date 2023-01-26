package model;

import model.cell.Cell;
import model.cell.OpenCell;
import util.CellUtil;
import view.swing.menu.CustomParams;

import java.util.Arrays;

public class Field {
    private final int cellSize;
    private final int rowsNumber;
    private final int columnsNumber;
    private final int bombsNumber;
    private int flagsNumber;
    private int closedCellsNumber;
    private boolean enabledAutoOpen;
    private Cell[][] cells;
    private Game game;

    public Field(
            int cellSize,
            int rowsNumber,
            int columnsNumber,
            int bombsNumber,
            int flagsNumber,
            int closedCellsNumber,
            boolean enabledAutoOpen,
            Cell[][] cells,
            Game game
    ) {
        this.rowsNumber = rowsNumber;
        this.columnsNumber = columnsNumber;
        this.bombsNumber = bombsNumber;
        this.flagsNumber = flagsNumber;
        this.cellSize = cellSize;
        this.closedCellsNumber = closedCellsNumber;
        this.enabledAutoOpen = enabledAutoOpen;
        addCells(cells);
        this.game = game;
    }

    private void addCells(Cell[][] cells) {
        CellUtil.getCellList(cells).forEach(cell -> cell.setField(this));
        this.cells = cells;
    }

    public Cell[][] getCells() {
        return Arrays.copyOf(cells, cells.length);
    }

    public void makeOpen(int row, int col, boolean byOpenCell) {
        final Cell cell = cells[row][col];

        if (byOpenCell && cell.isBomb()) {
            cell.openCell(row, col, this);
        }

        cells[row][col] = new OpenCell(cell);

        if (cell.isClosed()) {
            closedCellsNumber--;
        }
    }

    public void makeLosing(int row, int col) {
        cells[row][col].makeLosing();
        game.setState(GameState.LOSING);
    }

    public boolean isEnabledAutoOpen() {
        return enabledAutoOpen;
    }

    public void setAutoOpen(boolean enabledAutoOpen) {
        this.enabledAutoOpen = enabledAutoOpen;
    }

    public void toggleFlag(int row, int col) {
        final Cell cell = cells[row][col];
        if (cell.isNotFlagged()) {
            cells[row][col].toggleFlag(true);
            flagsNumber++;
        } else {
            cells[row][col].toggleFlag(false);
            flagsNumber--;
        }
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getRowsNumber() {
        return rowsNumber;
    }

    public int getColumnsNumber() {
        return columnsNumber;
    }

    public int getBombsNumber() {
        return bombsNumber;
    }

    public int getFlagsNumber() {
        return flagsNumber;
    }

    public int getClosedCellsNumber() {
        return closedCellsNumber;
    }

    public static FieldBuilder builder() {
        return new FieldBuilder();
    }

    public static class FieldBuilder {
        private int cellSize;
        private int rowsNumber;
        private int columnsNumber;
        private int bombsNumber;
        private int flagsNumber;
        private int closedCellsNumber;
        private boolean enabledAutoOpen;
        private Cell[][] cells;
        private Game game;

        public FieldBuilder cellSize(int cellSize) {
            this.cellSize = cellSize;
            return this;
        }

        public FieldBuilder rowsNumber(int rowsNumber) {
            this.rowsNumber = rowsNumber;
            return this;
        }

        public FieldBuilder columnsNumber(int columnsNumber) {
            this.columnsNumber = columnsNumber;
            return this;
        }

        public FieldBuilder bombsNumber(int bombsNumber) {
            this.bombsNumber = bombsNumber;
            return this;
        }

        public FieldBuilder flagsNumber(int flagsNumber) {
            this.flagsNumber = flagsNumber;
            return this;
        }

        public FieldBuilder closedCellsNumber(int closedCellsNumber) {
            this.closedCellsNumber = closedCellsNumber;
            return this;
        }

        public FieldBuilder enabledAutoOpen(boolean enabledAutoOpen) {
            this.enabledAutoOpen = enabledAutoOpen;
            return this;
        }

        public FieldBuilder cells(Cell[][] cells) {
            this.cells = cells;
            return this;
        }

        public FieldBuilder game(Game game) {
            this.game = game;
            return this;
        }

        public Field build() {
            return new Field(cellSize, rowsNumber, columnsNumber, bombsNumber, flagsNumber, closedCellsNumber, enabledAutoOpen, cells, game);
        }
    }
}
