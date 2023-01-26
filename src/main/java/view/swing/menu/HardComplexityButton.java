package view.swing.menu;

import view.SwingView;

import javax.swing.*;

import static util.ConfigConstants.*;
import static util.PropertyHelper.updateConfig;

public class HardComplexityButton extends JRadioButtonMenuItem {
    private final GameMenu menuBar;

    public HardComplexityButton(String name, GameMenu menuBar) {
        super(name, menuBar.getView().getController().isHardMode());
        this.menuBar = menuBar;

        addActionListener(e -> {
            updateConfig(ROWS_NUMBER_PROPERTY_NAME, ROWS_NUMBER_HARD_VALUE);
            updateConfig(COLUMNS_NUMBER_PROPERTY_NAME, COLUMNS_NUMBER_HARD_VALUE);
            updateConfig(BOMBS_NUMBER_PROPERTY_NAME, BOMBS_NUMBER_HARD_VALUE);

            final SwingView view = menuBar.getView();
            view.getController().restart();
            view.getWindow().setVisible(false);
            view.showWindow();
        });
    }
}
