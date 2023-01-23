package config;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GameSettings {
    int cellSize;
    int numberOfColumns;
    int numberOfRows;
    int numberOfBombs;
}
