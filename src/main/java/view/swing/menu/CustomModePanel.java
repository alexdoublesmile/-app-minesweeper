package view.swing.menu;

import javax.swing.*;
import java.awt.*;

public class CustomModePanel extends JPanel {
    private final GameMenu menuBar;

    public CustomModePanel(GameMenu menuBar) {
        super(new GridBagLayout(), true);
        this.menuBar = menuBar;
    }
}
