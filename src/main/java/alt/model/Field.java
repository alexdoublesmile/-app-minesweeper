package alt.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Field {

    private int numberOfRows;
    private int numberOfColumns;
    private int activeBombsNumber;
    private Cell[][] cells;
    private int cellSize;
}
