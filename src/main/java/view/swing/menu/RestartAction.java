package view.swing.menu;

import view.SwingView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartAction implements ActionListener {
    private final GameMenu menu;

    public RestartAction(GameMenu menuBar) {
        menu = menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final SwingView view = menu.getView();
        view.getPanel().updateModelInView(view.getController().restart().getField());

        view.getWindow().setVisible(false);
        view.showWindow();
    }
}
