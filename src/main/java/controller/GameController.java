package controller;

import model.Game;
import model.ModelInfo;
import service.GameService;

import static java.lang.Integer.parseInt;
import static util.ConfigConstants.*;

public final class GameController {
    private final GameService fieldService;

    public GameController(GameService fieldService) {
        this.fieldService = fieldService;
    }

    public Game start() {
        return fieldService.start();
    }

    public Game restart() {
        return start();
    }

    public Game initialize(int row, int col) {
        return fieldService.initialize(row, col);
    }

    public void makeChoice(int row, int col) {
        fieldService.openCell(row, col);
    }

    public void makeMark(int row, int col) {
        fieldService.toggleFlag(row, col);
    }

    public boolean isOver() {
        return fieldService.isOver();
    }

    public boolean isNotInitialized() {
        return fieldService.isNotInitialized();
    }

    public void updateAutoOpen(boolean enabledAutoOpen) {
        fieldService.updateAutoOpen(enabledAutoOpen);
    }

    public boolean isEasyMode() {
        return fieldService.checkMode(
                parseInt(ROWS_NUMBER_EASY_VALUE),
                parseInt(COLUMNS_NUMBER_EASY_VALUE),
                parseInt(BOMBS_NUMBER_EASY_VALUE));
    }

    public boolean isNormalMode() {
        return fieldService.checkMode(
                parseInt(ROWS_NUMBER_NORMAL_VALUE),
                parseInt(COLUMNS_NUMBER_NORMAL_VALUE),
                parseInt(BOMBS_NUMBER_NORMAL_VALUE));
    }

    public boolean isHardMode() {
        return fieldService.checkMode(
                parseInt(ROWS_NUMBER_HARD_VALUE),
                parseInt(COLUMNS_NUMBER_HARD_VALUE),
                parseInt(BOMBS_NUMBER_HARD_VALUE));
    }

    public ModelInfo getModelInfo() {
        return fieldService.getModelInfo();
    }

    public boolean isClosed(int row, int col) {
        return fieldService.isClosed(row, col);
    }
}
