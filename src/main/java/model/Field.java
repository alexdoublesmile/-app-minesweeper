package model;

import lombok.Builder;
import lombok.Getter;

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

    public Cell[][] getCells() {
        return Arrays.copyOf(cells, cells.length);
    }

    public List<Cell> getCellList() {
        return Stream.of(cells)
                .flatMap(Arrays::stream)
                .collect(toList());
    }

    public void makeOpen(int row, int col) {
        final Cell cell = cells[row][col];
        cell.makeOpen();

        closedCellsNumber--;
    }
}
