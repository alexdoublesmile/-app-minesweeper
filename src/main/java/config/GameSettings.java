package config;

import lombok.Getter;
import util.PropertyHelper;

@Getter
public final class GameSettings {
    private static final GameSettings INSTANCE = new GameSettings();
    // TODO: 25.01.2023 add size changing
    int cellSize = 50;
    int numberOfColumns = Integer.parseInt(PropertyHelper.getConfig("columns.number", "20"));
    int numberOfRows = Integer.parseInt(PropertyHelper.getConfig("rows.number", "20"));
    int numberOfBombs = Integer.parseInt(PropertyHelper.getConfig("bombs.number", "50"));
    boolean enabledAutoOpen = Boolean.parseBoolean(PropertyHelper.getConfig("auto.open", "true"));

    public static GameSettings INSTANCE() {
        return INSTANCE;
    }
}
