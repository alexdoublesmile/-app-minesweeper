package util;

import lombok.experimental.UtilityClass;
import model.Field;
import model.cell.Cell;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@UtilityClass
public class CellUtil {
    final Random RANDOM = new Random();

    public static Cell getNoBombRandomCell(Field field) {
        Cell randomCell;
        do {
            randomCell = getRandomCell(field);
        } while (randomCell.isBomb());

        return randomCell;
    }

    private static Cell getRandomCell(Field field) {
        int randomRow = RANDOM.nextInt(field.getRowsNumber());
        int randomColumn = RANDOM.nextInt(field.getColumnsNumber());

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
