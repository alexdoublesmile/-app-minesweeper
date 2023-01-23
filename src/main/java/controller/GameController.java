package controller;

import model.Field;
import model.Game;
import service.GameService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameController {

    private final GameService fieldService;

    public Game start() {
        return fieldService.initStartField();
    }

    public Game restart() {
        return start();
    }

    public boolean isGoing() {
        return fieldService.isGoing();
    }

    public Field getField() {
        return isGoing() ? fieldService.getField() : start().getField();
    }

    public void makeChoice(int row, int col) {
        if (!isGoing()) {
            return;
        }
        openCell(row, col);
        checkWinner();
    }

    public void makeMark(int row, int col) {
        if (!isGoing()) {
            return;
        }
        fieldService.toggleFlagged(row, col);
    }

    public String getMessage() {
        return fieldService.getMessageByState();
    }

    private void checkWinner() {
        if (isGoing() && fieldService.isOver()) {
            fieldService.setWinning();
        }
    }

    private void openCell(int row, int col) {
        fieldService.openCell(row, col);
    }
}
