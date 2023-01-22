package alt.util;

import alt.model.Cell;
import alt.model.CellType;
import alt.model.Field;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

@UtilityClass
public class FieldUtil {
    final Random RANDOM = new Random();

    public static boolean inRange(Cell cell, Cell[][] cells) {
        return Stream.of(cells)
                .flatMap(Arrays::stream)
                .anyMatch(cell::equals);
    }

    public static Cell getNoBombRandomCell(Field field) {
        Cell randomCell;
        do {
            randomCell = getRandomCell(field);
        } while (randomCell.getType() == CellType.BOMB);

        return randomCell;
    }

    private static Cell getRandomCell(Field field) {
        int randomRow = RANDOM.nextInt(field.getNumberOfRows());
        int randomColumn = RANDOM.nextInt(field.getNumberOfColumns());

        return field.getCells()[randomRow][randomColumn];
    }
}
