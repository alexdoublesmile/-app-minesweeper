package alt.view;

import alt.controller.GameController;
import alt.model.Game;
import alt.view.swing.Panel;
import alt.view.swing.Window;

public class SwingView implements View {

    private final GameController controller;

    private Window window;
    private Panel panel;

    public SwingView(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void showWindow() {
        window = new Window();
        panel = new Panel(controller.getField());
        window.add(panel);
        window.pack();
        window.setLocationRelativeTo(null);
    }

    @Override
    public ViewAction getAction() {
        return null;
    }

    @Override
    public void showAction(Game model) {

    }
}
