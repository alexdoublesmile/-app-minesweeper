package alt.controller;

import alt.model.Game;
import alt.model.GameState;
import alt.service.FieldService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameController {
    private final FieldService fieldService;

    public Game start() {
        return Game.builder()
                .field(fieldService.initStartField())
                .state(GameState.PLAYING)
                .build();
    }
}
