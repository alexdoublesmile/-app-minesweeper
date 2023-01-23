package alt.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Game {
    private Field field;
    private GameState state;
}
