package alt.controller;

import alt.model.Game;
import alt.service.GameService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameController {
    private final GameService fieldService;

    public Game start() {
        return fieldService.initStartField();
    }

    public boolean isGoing() {
        return fieldService.isGoing();
    }
}
