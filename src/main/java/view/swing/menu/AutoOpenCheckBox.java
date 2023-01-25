package view.swing.menu;

import util.PropertyHelper;

import javax.swing.*;

public class AutoOpenCheckBox extends JCheckBoxMenuItem {
    private final GameMenu menuBar;

    private boolean isEnabledAutoOpen;

    public AutoOpenCheckBox(String name, GameMenu menuBar) {
        super(name, menuBar.getController().getField().isEnabledAutoOpen());
        this.menuBar = menuBar;

        addActionListener(e -> {
            isEnabledAutoOpen = ((AbstractButton) e.getSource()).getModel().isSelected();
            updateModel(isEnabledAutoOpen);
            updateConfig(isEnabledAutoOpen);
        });
    }

    private void updateModel(boolean isEnabledAutoOpen) {
        menuBar.getController().updateAutoOpen(isEnabledAutoOpen);
    }

    private void updateConfig(boolean isEnabledAutoOpen) {
        PropertyHelper.updateConfig("auto.open", String.valueOf(isEnabledAutoOpen));
    }

    public boolean isEnabledAutoOpen() {
        return isEnabledAutoOpen;
    }
}
