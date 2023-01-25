package view.swing.menu;

import view.SwingView;

import javax.swing.*;
import java.awt.*;

import static util.ConfigConstants.*;
import static util.ConfigConstants.BOMBS_NUMBER_EASY_VALUE;
import static util.PropertyHelper.updateConfig;

public class CustomComplexityButton extends JMenuItem {
    private final GameMenu menuBar;

    public CustomComplexityButton(String name, GameMenu menuBar) {
        super(name);
        this.menuBar = menuBar;

        addActionListener(e -> {
            CustomModePanel customModePanel = new CustomModePanel(menuBar);

            GridBagConstraints constraints = new GridBagConstraints();
            constraints.anchor = GridBagConstraints.WEST;
            constraints.insets = new Insets(2, 2, 2, 2);

            constraints.gridx = 0;
            constraints.gridy = 0;
            customModePanel.add(new JLabel("Rows number: "), constraints);

            constraints.gridx = 1;
            final JTextField rowsNumber = new JTextField(3);
            customModePanel.add(rowsNumber, constraints);

            constraints.gridx = 0;
            constraints.gridy = 1;
            customModePanel.add(new JLabel("Columns number: "), constraints);

            constraints.gridx = 1;
            final JTextField columnsNumber = new JTextField(3);
            customModePanel.add(columnsNumber, constraints);

            constraints.gridx = 0;
            constraints.gridy = 2;
            customModePanel.add(new JLabel("Bombs number: "), constraints);

            constraints.gridx = 1;
            final JTextField bombsNumber = new JTextField(3);
            customModePanel.add(bombsNumber, constraints);

            setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createEtchedBorder(), "Custom mode"));

            final int result = JOptionPane.showConfirmDialog(null, customModePanel, "Custom Mode", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.OK_OPTION) {


                updateConfig(ROWS_NUMBER_PROPERTY_NAME, rowsNumber.getText());
                updateConfig(COLUMNS_NUMBER_PROPERTY_NAME, columnsNumber.getText());
                updateConfig(BOMBS_NUMBER_PROPERTY_NAME, bombsNumber.getText());

                final SwingView view = menuBar.getView();
                view.getPanel().updateModelInView(view.getController().restart().getField());
                view.getWindow().setVisible(false);
                view.showWindow();
            }

        });
    }
}
