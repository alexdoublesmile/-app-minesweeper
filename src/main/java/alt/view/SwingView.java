package alt.view;

import alt.controller.GameController;
import alt.view.swing.GamePanel;
import alt.view.swing.Window;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwingView implements View {

    private final GameController controller;

    private Window window;
    private GamePanel panel;

    public SwingView(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void showWindow() {
        window = new Window();
        panel = new GamePanel(controller.getField());
        window.add(panel);
        window.pack();
        window.setLocationRelativeTo(null);
    }

    @Override
    public void activateInteractions() {
        final int cellSize = controller.getField().getCellSize();
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                final String msg;
                int row = e.getX() / cellSize;
                int col = e.getY() / cellSize;
                if (e.getButton() == MouseEvent.BUTTON1) {
                    controller.makeChoice(row, col);
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    controller.makeMark(row, col);
                }
//                if (e.getButton() == MouseEvent.BUTTON2) {
//                    controller.start();
//                }
//                label.setText(getMessage());
                panel.repaint();
            }
        });
    }
}
