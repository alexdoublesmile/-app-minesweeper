import config.GameSettings;
import controller.GameController;
import service.GameService;
import view.SwingView;
import view.View;

public class Launcher {

    public static void main(String[] args) {
        final GameService gameService = new GameService(GameSettings.INSTANCE());
        final GameController game = new GameController(gameService);

        final View view = new SwingView(game);

        game.start();
        view.showWindow();
    }
}
