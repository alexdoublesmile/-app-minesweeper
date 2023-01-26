package view.swing.menu;

import util.PropertyHelper;

import javax.swing.*;

import static util.ConfigConstants.AUTO_OPEN_PROPERTY_NAME;

public class AutoOpenCheckBox extends JCheckBoxMenuItem {
    private final GameMenu menuBar;

    private boolean isEnabledAutoOpen;

    public AutoOpenCheckBox(String name, GameMenu menuBar) {
        super(name, menuBar.getView().getController().getModelInfo().isEnabledAutoOpen());
        this.menuBar = menuBar;

        addActionListener(e -> {
            isEnabledAutoOpen = ((AbstractButton) e.getSource()).getModel().isSelected();
            updateModel(isEnabledAutoOpen);
            updateConfig(isEnabledAutoOpen);
        });
    }

    private void updateModel(boolean isEnabledAutoOpen) {
        menuBar.getView().getController()
                .updateAutoOpen(isEnabledAutoOpen);
    }

    private void updateConfig(boolean isEnabledAutoOpen) {
        PropertyHelper.updateConfig(AUTO_OPEN_PROPERTY_NAME, String.valueOf(isEnabledAutoOpen));
    }
}
