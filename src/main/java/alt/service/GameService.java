package alt.service;

import alt.config.GameSettings;
import alt.model.*;

import static alt.util.FieldFactory.withSettings;
import static java.util.Objects.nonNull;

public final class GameService {

    private final GameSettings settings;

    private Game game;

    public GameService(GameSettings settings) {
        this.settings = settings;
    }

    public Game initStartField() {
        game = Game.builder()
                .field(withSettings(settings)
                        .initEmptyField()
                        .addCellsAround()
                        .addBombs()
                        .addNumbers()
                        .buildField())
                .state(GameState.PLAYING)
                .build();
        return game;
    }

    public boolean isGoing() {
        return nonNull(game) && GameState.PLAYING == game.getState();
    }

    public Field getField() {
        return game.getField();
    }

    public boolean isOver() {
        return getField().getClosedCellsNumber() == getField().getActiveBombsNumber();
    }

    public void openCell(int row, int col) {
        final Cell cell = game.getField().getCells()[row][col];
        if (cell.isFlagged()) {
            return;
        }
        if (cell.isOpen()) {
            setOpenedToClosedBoxesAroundNumber(cell);
        }
        if (!cell.isOpen() && cell.getType() == CellType.NUMBER) {
            game.getField().makeOpen(row, col);
        }
        if (!cell.isOpen() && cell.getType() == CellType.BOMB) {
            openBombs(cell);
        }
        if (!cell.isOpen() && cell.getType() == CellType.EMPTY) {
            openBoxesAround(cell);
        }
    }
}
