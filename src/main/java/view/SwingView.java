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
                    if (controller.isGoing()) {
                        controller.makeChoice(row, col);
                    }
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    if (controller.isGoing()) {
                        controller.makeMark(row, col);
                    }
                }
                if (e.getButton() == MouseEvent.BUTTON2) {
                    controller.restart();
                    panel.updateModel(controller.getField());
                }
                label.setText(controller.getMessage());
                panel.repaint();
            }
        });
    }

    @Override
    public void updateModel() {
        panel.updateModel(controller.getField());
        panel.repaint();
    }
}
