package alt.util;

import alt.model.Cell;
import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class FieldUtil {

    public static boolean inRange(Cell cell, Cell[][] cells) {
        return Arrays.asList(cells).contains(cell);

    }
}
