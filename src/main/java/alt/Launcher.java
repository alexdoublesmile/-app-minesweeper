package alt;

import alt.config.GameSettings;
import alt.controller.GameController;
import alt.service.GameService;
import alt.view.SwingView;
import alt.view.View;

public class Launcher {

    public static void main(String[] args) {

        Launcher.start();
    }

    public static void start() {
        final GameSettings settings = GameSettings.builder()
                .numberOfRows(9)
                .numberOfColumns(9)
                .numberOfBombs(10)
                .cellSize(50)
                .build();

        final GameService gameService = new GameService(settings);
        final GameController game = new GameController(gameService);

        final View view = new SwingView(game);

        view.showWindow();
        view.activateInteractions();
    }
}
