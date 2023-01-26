package model;

import model.cell.Cell;

import java.util.List;

public class ModelInfo {
    private ModelInfo(
            int cellSize,
            int rowsNumber,
            int columnsNumber,
            int bombsNumber,
            int flagsNumber,
            int closedCellsNumber,
            boolean enabledAutoOpen,
            List<Cell> cellList
    ) {
        this.cellSize = cellSize;
        this.rowsNumber = rowsNumber;
        this.columnsNumber = columnsNumber;
        this.bombsNumber = bombsNumber;
        this.flagsNumber = flagsNumber;
        this.closedCellsNumber = closedCellsNumber;
        this.enabledAutoOpen = enabledAutoOpen;
        this.cellList = cellList;
    }

    private final int cellSize;
    private final int rowsNumber;
    private final int columnsNumber;
    private final int bombsNumber;
    private final int flagsNumber;
    private final int closedCellsNumber;
    private final boolean enabledAutoOpen;
    private final List<Cell> cellList;

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

    public boolean isEnabledAutoOpen() {
        return enabledAutoOpen;
    }

    public List<Cell> getCellList() {
        return cellList;
    }

    public static ModelInfoBuilder builder() {
        return new ModelInfoBuilder();
    }

    public static class ModelInfoBuilder {
        private int cellSize;
        private int rowsNumber;
        private int columnsNumber;
        private int bombsNumber;
        private int flagsNumber;
        private int closedCellsNumber;
        private boolean enabledAutoOpen;
        private List<Cell> cellList;

        public ModelInfoBuilder cellSize(int cellSize) {
            this.cellSize = cellSize;
            return this;
        }

        public ModelInfoBuilder rowsNumber(int rowsNumber) {
            this.rowsNumber = rowsNumber;
            return this;
        }

        public ModelInfoBuilder columnsNumber(int columnsNumber) {
            this.columnsNumber = columnsNumber;
            return this;
        }

        public ModelInfoBuilder bombsNumber(int bombsNumber) {
            this.bombsNumber = bombsNumber;
            return this;
        }

        public ModelInfoBuilder flagsNumber(int flagsNumber) {
            this.flagsNumber = flagsNumber;
            return this;
        }

        public ModelInfoBuilder closedCellsNumber(int closedCellsNumber) {
            this.closedCellsNumber = closedCellsNumber;
            return this;
        }

        public ModelInfoBuilder enabledAutoOpen(boolean enabledAutoOpen) {
            this.enabledAutoOpen = enabledAutoOpen;
            return this;
        }

        public ModelInfoBuilder cellList(List<Cell> cellList) {
            this.cellList = cellList;
            return this;
        }

        public ModelInfo build() {
            return new ModelInfo(cellSize, rowsNumber, columnsNumber, bombsNumber, flagsNumber, closedCellsNumber, enabledAutoOpen, cellList);
        }
    }
}
