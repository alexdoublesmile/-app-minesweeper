package alt.service;

import alt.config.GameSettings;
import alt.model.Field;
import alt.util.FieldFactory;

public final class GameService {

    private final GameSettings settings;

    public GameService(GameSettings settings) {
        this.settings = settings;
    }

    public Field initStartField() {
        return FieldFactory.withSettings(settings)
                .initEmptyField()
                .addCellsAround()
                .addBombs()
                .addNumbers()
                .buildField();
    }
}
