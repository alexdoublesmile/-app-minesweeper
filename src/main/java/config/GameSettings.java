package config;

import lombok.Getter;

@Getter
public final class GameSettings {
    private static final GameSettings INSTANCE = new GameSettings();
    // TODO: 25.01.2023 take from config files
    // TODO: 25.01.2023 add size changing
    int cellSize = 50;
    int numberOfColumns = Integer.parseInt(PropertyConfig.getProperty("columns.number", "20"));
    int numberOfRows = Integer.parseInt(PropertyConfig.getProperty("rows.number", "20"));
    int numberOfBombs = Integer.parseInt(PropertyConfig.getProperty("bombs.number", "50"));
    boolean enabledAutoOpen = Boolean.parseBoolean(PropertyConfig.getProperty("auto.open", "true"));

    public static GameSettings INSTANCE() {
        return INSTANCE;
    }
}
