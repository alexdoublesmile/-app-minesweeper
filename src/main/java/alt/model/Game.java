package alt.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Game {
    private Field field;
    private GameState state;
}
