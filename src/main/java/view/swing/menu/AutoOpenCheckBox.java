package view.swing.menu;

import javax.swing.*;

public class AutoOpenCheckBox extends JCheckBoxMenuItem {
    private boolean isEnabledAutoOpen;

    public AutoOpenCheckBox(String name, boolean enabled) {
        super(name, enabled);

        addActionListener(e -> isEnabledAutoOpen = ((AbstractButton) e.getSource()).getModel().isSelected());
    }

    public boolean isEnabledAutoOpen() {
        return isEnabledAutoOpen;
    }
}
