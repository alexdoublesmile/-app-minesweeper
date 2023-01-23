import config.GameSettings;
import controller.GameController;
import service.GameService;
import view.SwingView;
import view.View;

public class Launcher {

    public static void main(String[] args) throws InterruptedException {
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

        gameLoop(game, view);
    }

    private static void gameLoop(GameController game, View view) throws InterruptedException {
        while (game.isGoing()) {
//            System.out.println("going...");
//            Thread.sleep(1000);
        }
//        System.out.println("-------- restarting ---------...");
//        System.out.println("-------- restarting ---------...");
//        System.out.println("-------- restarting ---------...");
        view.restartModel();
        gameLoop(game, view);
    }
}
