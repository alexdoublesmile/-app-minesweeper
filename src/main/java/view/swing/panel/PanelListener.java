package view.swing.panel;

import controller.GameController;
import view.SwingView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static view.swing.panel.PressType.*;

public class PanelListener extends MouseAdapter {
    private static final int LEFT_CLICK = MouseEvent.BUTTON1;
    private static final int RIGHT_CLICK = MouseEvent.BUTTON3;
    private static final int MIDDLE_CLICK = MouseEvent.BUTTON2;

    private final SwingView view;

    public PanelListener(SwingView view) {
        this.view = view;

    }

    @Override
    public void mousePressed(MouseEvent click) {
        final GameController controller = view.getController();
        final GamePanel panel = view.getPanel();
        final int cellSize = controller.getModelInfo().getCellSize();
        int row = click.getY() / cellSize;
        int col = click.getX() / cellSize;

        switch(getPressedType(click)) {
            case CHOICE:
                initializeIfNeeds(row, col);
                controller.makeChoice(row, col);
                break;
            case MARK: controller.makeMark(row, col);
                break;
            case RESET: controller.restart();
                break;
            default:
        }
        panel.repaint();
    }

    private void initializeIfNeeds(int row, int col) {
        if (view.getController().isNotInitialized()) {
            view.getController().initialize(row, col);
        }
    }

    private PressType getPressedType(MouseEvent e) {
        if (needRestart(e)) {
            return RESET;
        } else if (LEFT_CLICK == e.getButton()) {
            return CHOICE;
        } else if (RIGHT_CLICK == e.getButton()) {
            return MARK;
        }
        return NO_ACTION;
    }

    private boolean needRestart(MouseEvent e) {
        return e.getButton() == LEFT_CLICK && view.getController().isOver()
                || e.getButton() == RIGHT_CLICK && view.getController().isOver()
                || e.getButton() == MIDDLE_CLICK;
    }
}
