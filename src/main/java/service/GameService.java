package service;

import config.GameSettings;
import model.Field;
import model.Game;
import model.cell.Cell;
import util.FieldFactory;

import static java.util.Objects.nonNull;
import static model.GameState.LOSING;
import static model.GameState.PLAYING;
import static util.FieldFactory.withSettings;

public final class GameService {
    private final GameSettings settings;

    private Game game;

    public GameService(GameSettings settings) {
        this.settings = settings;
    }

    public Game initModel() {
        game = new Game();
        game.setState(PLAYING);
        Field field = withSettings(settings)
                .initEmptyField()
                .addBombs()
                .addCellsAround()
                .addNumbers()
                .build();

        game.setField(field);
        return game;
    }

    public boolean isGoing() {
        return nonNull(game) && PLAYING == game.getState();
    }

    public void openCell(int row, int col) {
        final Cell cell = game.getCell(row, col);
        cell.openCell(row, col, getField());

//        if (!cell.isFlagged()) {
//            if (cell.isOpen()) {
//                setOpenedToClosedBoxesAroundNumber(cell);
//            }
//            if (cell.isClosed() && cell.isNumber()) {
//                game.getField().makeOpen(row, col);
//            }
//            if (cell.isClosed() && cell.isBomb()) {
//                openBombs(cell);
//            }
//            if (cell.isClosed() && cell.isEmpty()) {
//                game.getField().makeOpen(row, col);
//                cell.getAroundCells().forEach(this::openCell);
//            }
//        }

        if (game.isOver() && game.getState() != LOSING) {
            game.makeWinning();
        }
    }

//    public void openCell(Cell cell) {
//        int row = cell.getRow();
//        int col = cell.getColumn();
//
//        if (cell.isFlagged()) {
//            return;
//        }
//        if (cell.isOpen()) {
//            setOpenedToClosedBoxesAroundNumber(cell);
//        }
//        if (!cell.isOpen() && cell.isNumber()) {
//            game.getField().makeOpen(row, col);
//        }
//        if (!cell.isOpen() && cell.isBomb()) {
//            openBombs(cell);
//        }
//        if (!cell.isOpen() && cell.isEmpty()) {
//            game.getField().makeOpen(row, col);
//            cell.getAroundCells().forEach(this::openCell);
//        }
//    }

//    private void setOpenedToClosedBoxesAroundNumber(Cell numberCell) {
//        final long flaggedCellsNumber = numberCell.getAroundCells()
//                .stream()
//                .filter(cell -> cell.isFlagged())
//                .count();
//
//        final long bombsNumber = numberCell.getAroundCells()
//                .stream()
//                .filter(cell -> CellType.BOMB == cell.getType())
//                .count();
//
//        if (flaggedCellsNumber == bombsNumber) {
//            numberCell.getAroundCells()
//                    .stream()
//                    .filter(cell -> !cell.isOpen())
//                    .forEach(this::openCell);
//        }
//    }

//    private void openBombs(Cell losingCell) {
//        game.makeLosing(losingCell);
//        game.getField().getCellList()
//                .stream()
//                .filter(cell -> CellType.BOMB == cell.getType() && !cell.isFlagged() || cell.isFlagged() && CellType.BOMB != cell.getType())
//                .forEach(Cell::makeOpen);
//    }

    public void toggleFlag(int row, int col) {
        game.getField().getCells()[row][col].toggleFlag();
    }

    public String getMessageByState() {
        switch (game.getState()) {
            case PLAYING: return "Think twice!";
            case LOSING: return "BOOM!";
            case WINNING: return "Congratulations!";
            default: return "Welcome!";
        }
    }

    public Field getField() {
        return game.getField();
    }
}
