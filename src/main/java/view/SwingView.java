package view;

import controller.GameController;
import view.swing.GamePanel;
import view.swing.Window;
import view.swing.listener.PanelListener;
import view.util.ViewConstants;

import javax.swing.*;
import java.awt.*;

public class SwingView implements View {
    private final GameController controller;

    private Window window;
    private GamePanel panel;
    private JLabel label;
    private JMenuBar menu;

    public SwingView(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void showWindow() {
        SwingUtilities.invokeLater(this::showWindowSeparateThread);
    }

    private void showWindowSeparateThread() {
        window = new Window();
        panel = new GamePanel(controller.getField());
        label = new JLabel(ViewConstants.GREETING_LABEL);
        menu = new JMenuBar();
        final JMenu gameMenu = new JMenu("Game");
        final JMenuItem newGame = new JMenuItem("New.. Game");
        final JMenuItem saveGame = new JMenuItem("Save.. Game");
        final JMenuItem loadGame = new JMenuItem("Load.. Game");
        gameMenu.add(newGame);
        gameMenu.add(saveGame);
        gameMenu.add(loadGame);

        final JMenu optionsMenu = new JMenu("Options");
        final JMenuItem topGame = new JMenuItem("TOP List");
        optionsMenu.add(topGame);

        final JMenu helpMenu = new JMenu("Help");
        final JMenuItem about = new JMenuItem("About");
        helpMenu.add(about);
        menu.add(gameMenu);
        menu.add(optionsMenu);
        menu.add(helpMenu);
        window.add(menu, BorderLayout.NORTH);
        window.add(label, BorderLayout.SOUTH);
        window.add(panel);
        window.pack();
        window.setLocationRelativeTo(null);

        panel.addMouseListener(new PanelListener(controller, panel, label));
    }
}
