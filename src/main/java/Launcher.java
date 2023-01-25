import controller.GameController;
import service.GameService;
import view.SwingView;
import view.View;

public class Launcher {

    public static void main(String[] args) {
        final GameController game = new GameController(new GameService());
        final View view = new SwingView(game);

        game.start();
        view.showWindow();
    }
}
