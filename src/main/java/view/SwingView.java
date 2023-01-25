package view;

import controller.GameController;
import lombok.Getter;
import view.swing.menu.GameMenu;
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
        panel = new GamePanel(controller.getField());
        menu = new GameMenu(this);
        label = new JLabel(ViewConstants.GREETING_LABEL);

        window.add(menu, BorderLayout.NORTH);
        window.add(label, BorderLayout.SOUTH);
        window.add(panel);
        window.pack();
        window.setLocationRelativeTo(null);

        panel.addMouseListener(new PanelListener(this));
    }
}
