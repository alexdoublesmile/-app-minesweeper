package alt.controller;

import alt.model.Field;
import alt.model.Game;
import alt.service.GameService;
import alt.view.ViewAction;
import lombok.RequiredArgsConstructor;
import model.Coord;
import model.GameState;

@RequiredArgsConstructor
public class GameController {
    private final GameService fieldService;

    public Game start() {
        return fieldService.initStartField();
    }

    public Game update(ViewAction action) {
        return null;
    }

    public boolean isGoing() {
        return fieldService.isGoing();
    }

    public Field getField() {
        return isGoing() ? fieldService.getField() : start().getField();
    }

    public String pressLeftButton(int row, int col) {
        if (!gameOver()) {
            openBox(row, col);
            checkWinner();
        }
    }

    private boolean gameOver() {
        if (state == GameState.PLAYED) {
            return false;
        }
        start();
        return true;
    }

    private void openBox(int row, int col) {
        switch (flag.get(coord)) {
            case OPENED: setOpenedToClosedBoxesAroundNumber(coord);
            case FLAGGED: return;
            case CLOSED:
                switch (bomb.get(coord)) {
                    case ZERO: openBoxesAround(coord);
                        break;
                    case BOMB: openBombs(coord);
                        break;
                    default: flag.setOpenedToBox(coord);
                }
        }
    }

    private void checkWinner() {
        if (state == GameState.PLAYED) {
            if (flag.getCountOfClosedBoxes() == bomb.getTotalBombs()) {
                state = GameState.WINNER;
            }
        }
    }

    public void pressRightButton(int row, int col) {
        if (gameOver()) {
            return;
        }
        flag.toggleFlaggedToBox(coord);
    }
}
