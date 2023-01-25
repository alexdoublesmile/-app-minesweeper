package service;

import config.GameSettings;
import model.Field;
import model.Game;
import model.cell.Cell;
import util.FieldFactory;

import static model.GameState.NOT_INITIALIZED;
import static model.GameState.PLAYING;
import static util.FieldFactory.withSettings;

public final class GameService {
    private final GameSettings settings;

    private Game game;

    public GameService(GameSettings settings) {
        this.settings = settings;
    }

    public Game start() {
        game = new Game();
        game.setState(NOT_INITIALIZED);
        Field field = withSettings(settings)
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

            cell.openCell(row, col, getField());
            game.setWinIfNeeds();
        }
    }

    public void toggleFlag(int row, int col) {
        game.getField().getCells()[row][col].toggleFlag();
    }

    public Field getField() {
        return game.getField();
    }

    public String getMessageByState() {
        switch (game.getState()) {
            case PLAYING: return "Think twice!";
            case LOSING: return "BOOM!";
            case WINNING: return "Congratulations!";
            default: return "Welcome!";
        }
    }

    public boolean isOver() {
        return game.isOver();
    }

    public boolean isNotInitialized() {
        return game.isNotInitialized();
    }
}
