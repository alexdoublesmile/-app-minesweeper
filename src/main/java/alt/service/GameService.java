package alt.service;

import alt.config.GameSettings;
import alt.model.*;
import model.Box;
import model.Coord;
import util.Ranges;

import static alt.util.FieldFactory.withSettings;
import static java.util.Objects.nonNull;

public final class GameService {

    private final GameSettings settings;

    private Game game;

    public GameService(GameSettings settings) {
        this.settings = settings;
    }

    public Game initStartField() {
        game = Game.builder()
                .field(withSettings(settings)
                        .initEmptyField()
                        .addCellsAround()
                        .addBombs()
                        .addNumbers()
                        .buildField())
                .state(GameState.PLAYING)
                .build();
        return game;
    }

    public boolean isGoing() {
        return nonNull(game) && GameState.PLAYING == game.getState();
    }

    public Field getField() {
        return game.getField();
    }

    public boolean isOver() {
        return getField().getClosedCellsNumber() == getField().getActiveBombsNumber();
    }

    public void openCell(int row, int col) {
        final Cell cell = game.getField().getCells()[row][col];
        if (cell.isFlagged()) {
            return;
        }
        if (cell.isOpen()) {
            setOpenedToClosedBoxesAroundNumber(cell);
        }
        if (!cell.isOpen() && cell.getType() == CellType.NUMBER) {
            game.getField().makeOpen(row, col);
        }
        if (!cell.isOpen() && cell.getType() == CellType.BOMB) {
            openBombs(cell);
        }
        if (!cell.isOpen() && cell.getType() == CellType.EMPTY) {
            game.getField().makeOpen(row, col);
            cell.getAroundCells().forEach(this::openCell);
        }
    }

    public void openCell(Cell cell) {
        int row = cell.getRow();
        int col = cell.getColumn();

        if (cell.isFlagged()) {
            return;
        }
        if (cell.isOpen()) {
            setOpenedToClosedBoxesAroundNumber(cell);
        }
        if (!cell.isOpen() && cell.getType() == CellType.NUMBER) {
            game.getField().makeOpen(row, col);
        }
        if (!cell.isOpen() && cell.getType() == CellType.BOMB) {
            openBombs(cell);
        }
        if (!cell.isOpen() && cell.getType() == CellType.EMPTY) {
            game.getField().makeOpen(row, col);
            cell.getAroundCells().forEach(this::openCell);
        }
    }

//    private void setOpenedToClosedBoxesAroundNumber(Coord coord) {
//        if (bomb.get(coord) != Box.BOMB) {
//            int flagCount = flag.getCountOfFlaggedBoxesAround(coord);
//            if (flagCount == bomb.get(coord).ordinal()) {
//                for (Coord aroundCoord : Ranges.getCoordsAround(coord)) {
//                    if (flag.get(aroundCoord) == Box.CLOSED) {
//                        openBox(aroundCoord);
//                    }
//                }
//            }
//        }
//    }

//    private void openBombs(Coord bombed) {
//        state = model.GameState.BOMBED;
//        flag.setBombToBox(bombed);
//        for (Coord coord : Ranges.getAllCoords()) {
//            if (bomb.get(coord) == Box.BOMB) {
//                flag.setOpenedToClosedBombBox(coord);
//            } else {
//                flag.setNoBombToFlaggedSafeBox(coord);
//            }
//        }
//    }
}
