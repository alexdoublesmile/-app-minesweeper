package alt.view;

import alt.controller.GameController;
import alt.model.Field;
import alt.model.Game;
import alt.view.swing.FieldView;
import alt.view.swing.ImageHelper;
import alt.view.swing.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwingView implements View {
    private final GameController controller;

    private Window window;
    private FieldView fieldView;

    public SwingView(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void showWindow(Field field) {
        window = new Window("Minesweeper");

        fieldView = new FieldView(field);
        fieldView.setPreferredSize(new Dimension(
                field.getNumberOfRows() * field.getCellSize(),
                field.getNumberOfColumns() * field.getCellSize()));
        window.add(fieldView);

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setIconImage(ImageHelper.getImageByName("icon"));
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        fieldView.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = e.getX() / field.getCellSize();
                int col = e.getY() / field.getCellSize();
                if (e.getButton() == MouseEvent.BUTTON1) {
                    controller.pressLeftButton(row, col);
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    controller.pressRightButton(row, col);
                }
//                if (e.getButton() == MouseEvent.BUTTON2) {
//                    controller.start();
//                }
//                label.setText(getMessage());
                fieldView.repaint();

            }
        });
    }

    @Override
    public ViewAction getAction() {
        return null;
    }

    @Override
    public void showAction(Game model) {

    }
}
