package alt.service;

import alt.config.GameSettings;
import alt.model.Game;
import alt.model.GameState;

import static alt.util.FieldFactory.withSettings;

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
        return GameState.PLAYING == game.getState();
    }
}
