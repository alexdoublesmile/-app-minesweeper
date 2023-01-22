package alt.controller;

import alt.config.GameSettings;
import alt.model.Field;
import alt.service.FieldService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Game {

    private final GameSettings settings;
    private final FieldService fieldService;

    public Field start() {
        return fieldService.initStartField(settings);
    }
}
