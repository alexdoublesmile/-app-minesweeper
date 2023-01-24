package model;

import lombok.Builder;
import lombok.Getter;
import model.cell.Cell;
import model.cell.FlaggedCell;
import model.cell.OpenCell;
import util.CellUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Getter
@Builder
public class Field {
    private int numberOfRows;
    private int numberOfColumns;
    private int activeBombsNumber;
    private Cell[][] cells;
    private int cellSize;
    private int closedCellsNumber;
    private Game game;

    public Field(int numberOfRows, int numberOfColumns, int activeBombsNumber, Cell[][] cells, int cellSize, int closedCellsNumber, Game game) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.activeBombsNumber = activeBombsNumber;
        addCells(cells);
        this.cellSize = cellSize;
        this.closedCellsNumber = closedCellsNumber;
    }

    private void addCells(Cell[][] cells) {
        CellUtil.getCellList(cells).forEach(cell -> cell.setField(this));
        this.cells = cells;
    }

    public Cell[][] getCells() {
        return Arrays.copyOf(cells, cells.length);
    }

    public void makeOpen(int row, int col) {
        final Cell cell = cells[row][col];
//        cell.makeOpen();
        cells[row][col] = new OpenCell(cell);


        if (cell.isClosed()) {
            closedCellsNumber--;
        }
    }

    public void toggleFlag(int row, int col) {
        final Cell cell = cells[row][col];
        cells[row][col] = new FlaggedCell(cell);

    }

    public void makeLosing(int row, int col) {
        cells[row][col].makeLosing();
        game.setState(GameState.LOSING);
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
