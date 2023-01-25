package config;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GameSettings {
    // TODO: 25.01.2023 take from config files
    // TODO: 25.01.2023 add size changing
    int cellSize = 50;
    int numberOfColumns;
    int numberOfRows;
    int numberOfBombs;
    boolean isEnabledAutoOpen;
}
