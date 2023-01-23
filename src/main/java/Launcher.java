import config.GameSettings;
import controller.GameController;
import service.GameService;
import view.SwingView;
import view.View;
import view.ViewAction;

public class Launcher {

    public static void main(String[] args) {
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

//    private static void gameLoop(GameController game, View view) {
//        while (game.isGoing()) {
//            ViewAction action = view.getAction();
//            game.makeAction(action);
//        }
//        game.restart();
//        view.updateModel();
//
//        gameLoop(game, view);
//    }
}
