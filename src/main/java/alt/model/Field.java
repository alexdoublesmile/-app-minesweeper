package alt.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Field {
    Info info;
    Menu menu;

    private int numberOfRows;
    private int numberOfColumns;
    private int activeBombsNumber;
    private Cell[][] cells;
}
