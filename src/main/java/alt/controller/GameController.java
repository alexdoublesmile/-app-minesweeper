package alt.controller;

import alt.model.Field;
import alt.model.Game;
import alt.model.GameState;
import alt.service.GameService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameController {

    private final GameService fieldService;

    public Game start() {
        return fieldService.initStartField();
    }

    public boolean isGoing() {
        return fieldService.isGoing();
    }

    public Field getField() {
        return isGoing() ? fieldService.getField() : start().getField();
    }

    public void makeChoice(int row, int col) {
        checkGameOver();
        openCell(row, col);
        checkWinner();
    }

    private void checkGameOver() {
        if (!isGoing()) start();
    }

    private void openCell(int row, int col) {
        fieldService.openCell(row, col);
    }

    private void checkWinner() {
        if (isGoing() && fieldService.isOver()) {
            fieldService.setWinning();
        }
    }

    public void makeMark(int row, int col) {
        checkGameOver();
        fieldService.toggleFlagged(row, col);
    }

    public String getMessage() {
        return fieldService.getMessageByState();
    }
}
