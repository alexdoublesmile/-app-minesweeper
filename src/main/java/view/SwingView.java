package view;

import controller.GameController;
import view.swing.GamePanel;
import view.swing.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwingView implements View {

    private final GameController controller;

    private view.swing.Window window;
    private GamePanel panel;
    private JLabel label;

    private boolean needRestart;

    public SwingView(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void showWindow() {
        window = new Window();
        panel = new GamePanel(controller.getField());
        label = new JLabel("Welcome");
        window.add(label, BorderLayout.SOUTH);
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
                int row = e.getX() / cellSize;
                int col = e.getY() / cellSize;
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (needRestart) {
                        updateModel();
                        needRestart = false;
                    } else {
                        controller.makeChoice(row, col);
                    }
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    if (needRestart) {
                        updateModel();
                        needRestart = false;
                    } else {
                        controller.makeMark(row, col);
                    }
                }
                if (e.getButton() == MouseEvent.BUTTON2) {
                    panel.updateModel(controller.restart().getField());
                }
                label.setText(controller.getMessage());
                panel.repaint();
            }
        });
    }

    @Override
    public void restartModel() {
        needRestart = true;
    }

    private void updateModel() {
        panel.updateModel(controller.restart().getField());
//        panel.repaint();
    }
}
