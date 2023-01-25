package view.swing.menu;

import javax.swing.*;

import static util.ConfigConstants.*;
import static util.PropertyHelper.updateConfig;

public class NormalComplexityButton extends JRadioButtonMenuItem {
    private final GameMenu menuBar;

    public NormalComplexityButton(String name, GameMenu menuBar) {
        super(name, menuBar.getView().getController().isNormalComplexity());
        this.menuBar = menuBar;

        addActionListener(e -> {
            updateConfig(ROWS_NUMBER_PROPERTY_NAME, ROWS_NUMBER_NORMAL_VALUE);
            updateConfig(COLUMNS_NUMBER_PROPERTY_NAME, COLUMNS_NUMBER_NORMAL_VALUE);
            updateConfig(BOMBS_NUMBER_PROPERTY_NAME, BOMBS_NUMBER_NORMAL_VALUE);
        });
    }
}
