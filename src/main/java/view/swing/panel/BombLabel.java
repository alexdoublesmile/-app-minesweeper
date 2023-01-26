package view.swing.panel;

import view.SwingView;

import javax.swing.*;

public class BombLabel extends JLabel {
    private final SwingView view;

        public BombLabel(SwingView view) {
            this.view = view;
            setHorizontalAlignment(SwingConstants.LEFT);
        }
}
