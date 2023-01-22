package alt.service;

import alt.model.Cell;
import alt.util.FieldUtil;

import java.util.ArrayList;
import java.util.List;

public class CellService {

    public List<Cell> addCellsAround(Cell currentCell, Cell[][] cells) {
        List<Cell> aroundCells = new ArrayList<>();

        for (int row = currentCell.getRow() - 1; row <= currentCell.getRow() + 1; row++) {
            for (int column = currentCell.getColumn() - 1; column <= currentCell.getColumn() + 1; column++) {
                final Cell aroundCell = cells[row][column];

                if (FieldUtil.inRange(aroundCell, cells)
                        && !aroundCell.equals(currentCell)) {
                    aroundCells.add(aroundCell);
                }
            }
        }
        return aroundCells;
    }
}
