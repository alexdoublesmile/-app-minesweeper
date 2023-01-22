package alt.controller;

import alt.model.Game;
import alt.model.GameState;
import alt.service.GameService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameController {
    private final GameService fieldService;

    public Game start() {
        return Game.builder()
                .field(fieldService.initStartField())
                .state(GameState.PLAYING)
                .build();
    }

    public boolean isGoing() {
        return fieldService.isGoing();
    }
}
