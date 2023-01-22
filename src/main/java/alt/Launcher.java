package alt;

import alt.config.GameSettings;
import alt.controller.GameController;
import alt.service.GameService;
import alt.view.SwingView;
import alt.view.View;

public class Launcher {
    public static void main(String[] args) {
        final GameSettings settings = GameSettings.builder()
                .numberOfRows(9)
                .numberOfColumns(9)
                .numberOfBombs(10)
                .cellSize(50)
                .build();

        final GameService fieldService = new GameService(settings);
        final GameController game = new GameController(fieldService);
        final View view = new SwingView();

        view.showWindow(game.start());

        while (game.isGoing()) {
            view.showAction(game.update(view.getAction()));
        }
    }
}
