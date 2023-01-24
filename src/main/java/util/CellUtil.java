package util;

import lombok.experimental.UtilityClass;
import model.Field;
import model.cell.Cell;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static model.cell.CellType.EMPTY;

@UtilityClass
public class CellUtil {
    public static Cell getNoBombRandomCell(Field field, int row, int column) {
        Cell safeCell = new Cell(row, column, EMPTY, false);
        Cell randomCell;
        do {
            randomCell = getRandomCell(field);
        } while (randomCell.isBomb() || randomCell.equals(safeCell));

        return randomCell;
    }

    private static Cell getRandomCell(Field field) {
        int randomRow = ThreadLocalRandom.current().nextInt(field.getRowsNumber());
        int randomColumn = ThreadLocalRandom.current().nextInt(field.getColumnsNumber());

        return field.getCells()[randomRow][randomColumn];
    }

    public static boolean isValidCoords(int row, int column, Field field) {
        return row >= 0 && row < field.getRowsNumber()
                && column >= 0 && column < field.getColumnsNumber();
    }

    public List<Cell> getCellList(Cell[][] cells) {
        return Stream.of(cells)
                .flatMap(Arrays::stream)
                .collect(toList());
    }
}
