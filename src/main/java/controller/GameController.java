package controller;

import model.Field;
import model.Game;
import service.GameService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class GameController {
    private final GameService fieldService;

    public Game start() {
        return fieldService.initStartField();
    }

    public Game restart() {
        return start();
    }

    public void makeChoice(int row, int col) {
        fieldService.openCell(row, col);
    }

    public void makeMark(int row, int col) {
        fieldService.toggleFlagged(row, col);
    }

    public Field getField() {
        return fieldService.getField();
    }

    public String getMessage() {
        return fieldService.getMessageByState();
    }

    public boolean isGoing() {
        return fieldService.isGoing();
    }
}
