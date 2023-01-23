package alt.controller;

import alt.model.Field;
import alt.model.Game;
import alt.service.GameService;
import alt.view.ViewAction;
import lombok.RequiredArgsConstructor;

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
}
