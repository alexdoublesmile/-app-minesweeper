package view.swing.menu;

import javax.swing.*;

public class AutoOpenCheckBox extends JCheckBoxMenuItem {
    private final GameMenu menuBar;

    private boolean isEnabledAutoOpen;

    public AutoOpenCheckBox(String name, GameMenu menuBar) {
        super(name, menuBar.getController().getField().isEnabledAutoOpen());
        this.menuBar = menuBar;

        addActionListener(e -> {
            final AbstractButton checkbox = (AbstractButton) e.getSource();
            isEnabledAutoOpen = checkbox.getModel().isSelected();
            menuBar.getController().updateAutoOpen(isEnabledAutoOpen);
        });
    }

    public boolean isEnabledAutoOpen() {
        return isEnabledAutoOpen;
    }
}
