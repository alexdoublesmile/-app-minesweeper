package model;

import lombok.Builder;
import lombok.Value;
import model.cell.Cell;

import java.util.List;

@Value
@Builder
public class ModelInfo {
    int cellSize;
    int rowsNumber;
    int columnsNumber;
    int bombsNumber;
    int flagsNumber;
    int closedCellsNumber;
    boolean enabledAutoOpen;
    List<Cell> cellList;
}
