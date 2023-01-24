package view.swing.listener;

import controller.GameController;
import view.swing.GamePanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static view.swing.listener.PressType.*;

public class PanelListener extends MouseAdapter {
    private static final int LEFT_CLICK = MouseEvent.BUTTON1;
    private static final int RIGHT_CLICK = MouseEvent.BUTTON3;
    private static final int MIDDLE_CLICK = MouseEvent.BUTTON2;

    private GameController controller;
    private GamePanel panel;
    private JLabel label;

    public PanelListener(GameController controller, GamePanel panel, JLabel label) {
        this.controller = controller;
        this.panel = panel;
        this.label = label;
    }

    @Override
    public void mousePressed(MouseEvent click) {
        final int cellSize = controller.getField().getCellSize();
        int row = click.getX() / cellSize;
        int col = click.getY() / cellSize;

        switch(getPressedType(click)) {
            case CHOICE: controller.makeChoice(row, col);
                break;
            case MARK: controller.makeMark(row, col);
                break;
            case RESET: panel.updateModel(controller.restart().getField());
                break;
            default:
        }
        label.setText(controller.getMessage());
        panel.repaint();
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
        return e.getButton() == LEFT_CLICK && !controller.isGoing()
                || e.getButton() == RIGHT_CLICK && !controller.isGoing()
                || e.getButton() == MIDDLE_CLICK;
    }
}