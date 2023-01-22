package alt.service;

import alt.config.GameSettings;
import alt.model.Field;
import alt.util.FieldFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class FieldService {

    public Field initStartField(GameSettings settings) {
        return FieldFactory.getINSTANCE()
                .initEmptyField(settings)
                .addCellsAround()
                .addBombs()
                .addNumbers()
                .buildField();
    }
}
