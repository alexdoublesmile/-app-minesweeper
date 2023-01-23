package alt.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;

@Getter
@Builder
public class Field {
    private int numberOfRows;
    private int numberOfColumns;
    private int activeBombsNumber;
    private Cell[][] cells;
    private int cellSize;

    public Cell[][] getCells() {
        return Arrays.copyOf(cells, cells.length);
    }
}
