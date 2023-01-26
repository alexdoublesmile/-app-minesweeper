package view.swing.menu;

import view.SwingView;

import javax.swing.*;
import java.awt.*;

import static java.lang.Integer.parseInt;
import static util.ConfigConstants.*;
import static util.PropertyHelper.getConfig;
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
            final JTextField rowsNumber = new JTextField(getConfig(ROWS_NUMBER_PROPERTY_NAME), 3);
            customModePanel.add(rowsNumber, constraints);

            constraints.gridx = 0;
            constraints.gridy = 1;
            customModePanel.add(new JLabel("Columns number: "), constraints);

            constraints.gridx = 1;
            final JTextField columnsNumber = new JTextField(getConfig(COLUMNS_NUMBER_PROPERTY_NAME), 3);
            customModePanel.add(columnsNumber, constraints);

            constraints.gridx = 0;
            constraints.gridy = 2;
            customModePanel.add(new JLabel("Bombs number: "), constraints);

            constraints.gridx = 1;
            final JTextField bombsNumber = new JTextField(getConfig(BOMBS_NUMBER_PROPERTY_NAME), 3);
            customModePanel.add(bombsNumber, constraints);

            final int result = JOptionPane.showConfirmDialog(null, customModePanel, "Custom Mode", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                final CustomParams customParams = CustomParams.builder()
                        .rows(parseInt(rowsNumber.getText()))
                        .columns(parseInt(columnsNumber.getText()))
                        .bombs(parseInt(bombsNumber.getText()))
                        .build();

                updateConfig(ROWS_NUMBER_PROPERTY_NAME, String.valueOf(customParams.normalizedRows()));
                updateConfig(COLUMNS_NUMBER_PROPERTY_NAME, String.valueOf(customParams.normalizedColumns()));
                updateConfig(BOMBS_NUMBER_PROPERTY_NAME, String.valueOf(customParams.normalizedBombs()));

                final SwingView view = menuBar.getView();
                view.getPanel().updateModelInView(view.getController().restart().getField());
                view.getWindow().setVisible(false);
                view.showWindow();
            }
        });
    }
}
