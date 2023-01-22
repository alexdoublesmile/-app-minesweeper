package alt.view;

import alt.model.Field;
import alt.model.Game;
import alt.view.swing.FieldView;
import alt.view.swing.ImageHelper;
import alt.view.swing.Window;

import javax.swing.*;
import java.awt.*;

public class SwingView implements View {

    private Window window;
    private FieldView fieldView;

    @Override
    public void showWindow(Game model) {
        final Field field = model.getField();

        window = new Window("Minesweeper");

        fieldView = new FieldView(model);
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
    }
}
