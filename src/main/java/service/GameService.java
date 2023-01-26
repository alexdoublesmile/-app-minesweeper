package service;

import config.GameSettings;
import model.Field;
import model.Game;
import model.ModelInfo;
import model.cell.Cell;
import util.CellUtil;
import util.FieldFactory;

import java.util.ArrayList;
import java.util.List;

import static model.GameState.NOT_INITIALIZED;
import static model.GameState.PLAYING;
import static util.FieldFactory.withSettings;

public final class GameService {
    private Game game;

    public Game start() {
        game = new Game();
        game.setState(NOT_INITIALIZED);
        Field field = withSettings(new GameSettings())
                .initEmptyField(game)
                .build();

        game.setField(field);
        return game;
    }

    public Game initialize(int row, int col) {
        game.setState(PLAYING);
        Field field = FieldFactory.started()
                .addBombs(row, col)
                .addCellsAround()
                .addNumbers()
                .build();

        game.setField(field);
        return game;
    }

    public void openCell(int row, int col) {
        final Cell cell = game.getCell(row, col);
        if (cell.isNotFlagged()) {

            cell.openCell(row, col, game.getField());
            game.setWinIfNeeds();
        }
    }

    public void toggleFlag(int row, int col) {
        game.getField().getCells()[row][col].toggleFlag();
    }

//    public Field getField() {
//        return game.getField();
//    }

//    public String getMessageByState() {
//        switch (game.getState()) {
//            case PLAYING: return "Think twice!";
//            case LOSING: return "BOOM!";
//            case WINNING: return "Congratulations!";
//            default: return "Welcome!";
//        }
//    }

    public boolean isOver() {
        return game.isOver();
    }

    public boolean isNotInitialized() {
        return game.isNotInitialized();
    }

    public void updateAutoOpen(boolean enabledAutoOpen) {
        game.getField().setAutoOpen(enabledAutoOpen);
    }

    public boolean checkMode(int checkRows, int checkColumns, int checkBombs) {
        final Field field = game.getField();
        int rows = field.getRowsNumber();
        int columns = field.getColumnsNumber();
        int bombs = field.getBombsNumber();
        return rows == checkRows && columns == checkColumns && bombs == checkBombs;
    }

    public String getBombsNumber() {
        return String.valueOf(game.getField().getBombsNumber());
    }

    public ModelInfo getModelInfo() {
        final Field field = game.getField();
        return ModelInfo.builder()
                .cellSize(field.getCellSize())
                .rowsNumber(field.getRowsNumber())
                .columnsNumber(field.getColumnsNumber())
                .bombsNumber(field.getBombsNumber())
                .flagsNumber(field.getFlagsNumber())
                .closedCellsNumber(field.getClosedCellsNumber())
                .enabledAutoOpen(field.isEnabledAutoOpen())
                .cellList(new ArrayList<>(CellUtil.getCellList(field.getCells())))
                .build();
    }
}
