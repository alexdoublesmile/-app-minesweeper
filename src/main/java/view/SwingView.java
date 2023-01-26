package view;

import controller.GameController;
import lombok.Getter;
import view.swing.Window;
import view.swing.menu.GameMenu;
import view.swing.panel.BombLabel;
import view.swing.panel.GamePanel;
import view.swing.panel.PanelListener;

import javax.swing.*;
import java.awt.*;

@Getter
public class SwingView implements View {
    private final GameController controller;

    private Window window;
    private GameMenu menu;
    private GamePanel gamePanel;
    private BombLabel bombLabel;

    public SwingView(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void showWindow() {
        SwingUtilities.invokeLater(this::showWindowSeparateThread);
    }

    private void showWindowSeparateThread() {
        window = new Window();
        menu = new GameMenu(this);
        gamePanel = new GamePanel(controller, bombLabel);

        window.add(menu, BorderLayout.NORTH);
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);

        gamePanel.addMouseListener(new PanelListener(this));
    }
}
