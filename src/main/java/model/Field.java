package model;

import lombok.Builder;
import lombok.Getter;
import model.cell.Cell;
import model.cell.OpenCell;
import util.CellUtil;

import java.util.Arrays;

@Getter
@Builder
public class Field {
    private final int rowsNumber;
    private final int columnsNumber;
    private final int bombsNumber;
    private final int cellSize;

    private int closedCellsNumber;
    private Cell[][] cells;
    private Game game;

    public Field(int rowsNumber, int columnsNumber, int bombsNumber, int cellSize, int closedCellsNumber, Cell[][] cells, Game game) {
        this.rowsNumber = rowsNumber;
        this.columnsNumber = columnsNumber;
        this.bombsNumber = bombsNumber;
        this.cellSize = cellSize;
        this.closedCellsNumber = closedCellsNumber;
        addCells(cells);
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

    public void setGame(Game game) {
        this.game = game;
    }
}
