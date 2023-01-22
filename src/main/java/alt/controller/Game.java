package alt.controller;

import alt.config.GameSettings;
import alt.model.Field;
import alt.service.FieldService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Game {

    private final GameSettings settings;
    private final FieldService fieldService;

    public void start() {
        final Field startField = fieldService.initStartField(settings);
    }
}
