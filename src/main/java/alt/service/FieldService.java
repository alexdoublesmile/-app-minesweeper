package alt.service;

import alt.config.GameSettings;
import alt.model.Field;
import alt.util.FieldFactory;

public final class FieldService {

    private final GameSettings settings;

    public FieldService(GameSettings settings) {
        this.settings = settings;
    }

    public Field initStartField() {
        return FieldFactory.withSettings(settings)
                .initEmptyField()
//                .addCellsAround()
                .addBombs()
                .addNumbers()
                .buildField();
    }
}
