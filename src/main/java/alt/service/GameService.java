package alt.service;

import alt.config.GameSettings;
import alt.model.Field;
import alt.model.Game;
import alt.model.GameState;

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
}
