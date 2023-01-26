package view;

import controller.GameController;
import lombok.Getter;
import view.swing.menu.GameMenu;
import view.swing.panel.BombLabel;
import view.swing.panel.GamePanel;
import view.swing.Window;
import view.swing.panel.PanelListener;

import javax.swing.*;
import java.awt.*;

@Getter
public class SwingView implements View {
    private final GameController controller;

    private Window window;
    private GamePanel panel;
    private GameMenu menu;
    private BombLabel bombLabel;
//    private JLabel label;

    public SwingView(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void showWindow() {
        SwingUtilities.invokeLater(this::showWindowSeparateThread);
    }

    @Override
    public void restart() {
        window = new Window();
    }

    private void showWindowSeparateThread() {
        window = new Window();
        menu = new GameMenu(this);
        bombLabel = new BombLabel(this);
        panel = new GamePanel(controller, bombLabel);

        window.add(menu, BorderLayout.NORTH);
        window.add(panel);
        window.add(bombLabel, BorderLayout.SOUTH);

        window.pack();
        window.setLocationRelativeTo(null);

        panel.addMouseListener(new PanelListener(this));
    }
}
