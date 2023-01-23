package alt.model;

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

    public Cell[][] getCells() {
        return Arrays.copyOf(cells, cells.length);
    }

    public List<Cell> getCellsList() {
        return Stream.of(cells)
                .flatMap(Arrays::stream)
                .collect(toList());
    }
}
