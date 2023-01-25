package controller;

import lombok.RequiredArgsConstructor;
import model.Field;
import model.Game;
import service.GameService;

import static java.lang.Integer.parseInt;
import static util.ConfigConstants.*;

@RequiredArgsConstructor
public final class GameController {
    private final GameService fieldService;

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

    public Field getField() {
        return fieldService.getField();
    }

    public String getMessage() {
        return fieldService.getMessageByState();
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

    public boolean isEasyComplexity() {
        return fieldService.checkComplexity(
                parseInt(ROWS_NUMBER_EASY_VALUE),
                parseInt(COLUMNS_NUMBER_EASY_VALUE),
                parseInt(BOMBS_NUMBER_EASY_VALUE));
    }

    public boolean isNormalComplexity() {
        return fieldService.checkComplexity(
                parseInt(ROWS_NUMBER_NORMAL_VALUE),
                parseInt(COLUMNS_NUMBER_NORMAL_VALUE),
                parseInt(BOMBS_NUMBER_NORMAL_VALUE));
    }

    public boolean isHardComplexity() {
        return fieldService.checkComplexity(
                parseInt(ROWS_NUMBER_HARD_VALUE),
                parseInt(COLUMNS_NUMBER_HARD_VALUE),
                parseInt(BOMBS_NUMBER_HARD_VALUE));
    }
}
