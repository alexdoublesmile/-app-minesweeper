package alt.service;

import alt.config.GameSettings;
import alt.model.Cell;
import alt.model.CellType;
import alt.model.Info;
import alt.model.Field;
import model.Coord;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StartService {

    public Field initField(GameSettings settings) {
        Cell[][] cells = new Cell[settings.getNumberOfRows()][settings.getNumberOfColumns()];

        for (int i = 0; i < settings.getNumberOfRows(); i++) {
            for (int j = 0; j < settings.getNumberOfColumns(); j++) {
                cells[i][j] = Cell.builder()
                        .row(i)
                        .column(j)
                        .size(settings.getCellSize())
                        .type(CellType.EMPTY)
                        .build();
            }
        }
        // TODO: 21.01.2023 add around cells
        // TODO: 21.01.2023 add bombs
        // TODO: 21.01.2023 add numbers

        return Field.builder()
                .cells(cells)
                .info(Info.builder().message("Hi").build())
                .build();
    }

//    public static List<Coord> getCoordsAround(Coord coord) {
//        Coord around;
//        List<Coord> coords = new ArrayList<>();
//        for (int i = coord.getX() - 1; i <= coord.getX() + 1; i++) {
//            for (int j = coord.getY() - 1; j <= coord.getY() + 1; j++) {
//                if (inRange(around = new Coord(i, j))) {
//                    if (!around.equals(coord)) {
//                        coords.add(around);
//                    }
//                }
//            }
//        }
//        return coords;
//    }
//
//    public static boolean inRange(Cell cell) {
//        return allCoords.contains(cell);
//    }
//
//    public static Coord getRandomCoord() {
//        return new Coord(random.nextInt(size.getX()), random.nextInt(size.getY()));
//    }
}
