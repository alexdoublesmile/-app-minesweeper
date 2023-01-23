package alt.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Game {
    private Field field;
    private GameState state;

    public void makeLosing(Cell cell) {
        state = GameState.LOSING;
        cell.makeLosing();
    }

    public void makeWinning() {
        state = GameState.WINNING;
    }
}
