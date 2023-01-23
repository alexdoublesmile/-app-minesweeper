package view.swing.listener;

import controller.GameController;
import view.swing.GamePanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static view.swing.listener.PressType.*;

public class PanelListener extends MouseAdapter {
    private GameController controller;
    private GamePanel panel;
    private JLabel label;

    public PanelListener(GameController controller, GamePanel panel, JLabel label) {
        this.controller = controller;
        this.panel = panel;
        this.label = label;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        final int cellSize = controller.getField().getCellSize();
        int row = e.getX() / cellSize;
        int col = e.getY() / cellSize;

        switch(pressedType(e)) {
            case CHOICE: controller.makeChoice(row, col);
                break;
            case MARK: controller.makeMark(row, col);
                break;
            case RESET: panel.updateModel(controller.restart().getField());
                break;
            default:
        }
//        if (needRestart(e)) {
//            controller.restart();
//            panel.updateModel(controller.getField());
//
//        }
//
//        if (e.getButton() == MouseEvent.BUTTON1) {
//            controller.makeChoice(row, col);
//        }
//        if (e.getButton() == MouseEvent.BUTTON3) {
//            controller.makeMark(row, col);
//        }
        label.setText(controller.getMessage());
        panel.repaint();
    }

    private PressType pressedType(MouseEvent e) {
        if (needRestart(e)) {
            return RESET;
        }
        if (e.getButton() == MouseEvent.BUTTON1) {
            return CHOICE;
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            return MARK;
        }
        return NO_ACTION;
    }

    private boolean needRestart(MouseEvent e) {
        return (e.getButton() == MouseEvent.BUTTON1 && !controller.isGoing())
                || (e.getButton() == MouseEvent.BUTTON3 && !controller.isGoing())
                || e.getButton() == MouseEvent.BUTTON2;
    }
}
