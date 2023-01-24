package controller;

import model.Field;
import model.Game;
import service.GameService;
import lombok.RequiredArgsConstructor;

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

    public boolean isGoing() {
        return fieldService.isGoing();
    }

    public boolean isOver() {
        return fieldService.isOver();
    }

    public boolean areBombsFounded() {
        return fieldService.areBombsFounded();
    }

    public boolean isNotInitialized() {
        return fieldService.isNotInitialized();
    }
}
