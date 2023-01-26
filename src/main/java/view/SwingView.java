package view;

import controller.GameController;
import lombok.Getter;
import view.swing.menu.GameMenu;
import view.swing.panel.ClockLabel;
import view.swing.panel.GamePanel;
import view.swing.Window;
import view.swing.panel.PanelListener;
import view.util.ViewConstants;

import javax.swing.*;
import java.awt.*;

@Getter
public class SwingView implements View {
    private final GameController controller;

    private Window window;
    private GamePanel panel;
    private GameMenu menu;
    private ClockLabel clockLabel;
    private JLabel label;

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
        panel = new GamePanel(controller);
        menu = new GameMenu(this);
        // TODO: 25.01.2023 add bombs number online here
        label = new JLabel(ViewConstants.GREETING_LABEL);
        clockLabel = new ClockLabel(this);

        window.add(menu, BorderLayout.NORTH);
        window.add(clockLabel, BorderLayout.SOUTH);
        window.add(panel);

        window.pack();
        window.setLocationRelativeTo(null);

        panel.addMouseListener(new PanelListener(this));
    }
}
