package alt.service;

import alt.config.GameSettings;
import alt.model.Field;
import alt.util.FieldFactory;

public final class FieldService {
    private static final FieldService INSTANCE = new FieldService();
    private GameSettings settings;

    private FieldService() {
    }

    public Field initStartField() {
        return FieldFactory.getINSTANCE()
                .initEmptyField(settings)
                .addCellsAround()
                .addBombs()
                .addNumbers()
                .buildField();
    }

    public static FieldService withSettings(GameSettings settings) {
        return INSTANCE.getInstanceWithSettings(settings);
    }

    private FieldService getInstanceWithSettings(GameSettings settings) {
        this.settings = settings;
        return this;
    }
}
