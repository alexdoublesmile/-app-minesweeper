package config;

import lombok.Getter;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static util.ConfigConstants.*;
import static util.PropertyHelper.getConfig;

@Getter
public final class GameSettings {
    // TODO: 25.01.2023 add size changing
    private final int cellSize = CELL_SIZE_DEFAULT_VALUE;
    private final int numberOfColumns = parseInt(getConfig(COLUMNS_NUMBER_PROPERTY_NAME, COLUMNS_NUMBER_DEFAULT_VALUE));
    private final int numberOfRows = parseInt(getConfig(ROWS_NUMBER_PROPERTY_NAME, ROWS_NUMBER_DEFAULT_VALUE));
    private final int numberOfBombs = parseInt(getConfig(BOMBS_NUMBER_PROPERTY_NAME, BOMBS_NUMBER_DEFAULT_VALUE));
    private final boolean enabledAutoOpen = parseBoolean(getConfig(AUTO_OPEN_PROPERTY_NAME, AUTO_OPEN_DEFAULT_VALUE));
}
