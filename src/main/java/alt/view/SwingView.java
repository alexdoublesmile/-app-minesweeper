package alt.view;

import alt.model.Cell;
import alt.model.CellImgType;
import alt.model.Field;
import alt.model.Game;
import view.FieldView;
import view.Window;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SwingView implements View<Image> {

    private Window window;
    private FieldView fieldView;

    @Override
    public void showWindow(Game game) {
        final Field field = game.getField();

        window = new Window("Minesweeper");

        initPanel(field);

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setIconImage(getImage("icon"));
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    @Override
    public Image getImageByType(CellImgType imgType) {
        return getImage(imgType.name().toLowerCase());
    }

    private void initPanel(Field field) {
        final List<Cell> cells = Stream.of(field.getCells())
                .flatMap(Arrays::stream)
                .collect(toList());

        fieldView = new FieldView() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Cell cell : cells) {
                    g.drawImage(
                            getImageByType(CellImgType.getByCell(cell)),
                            cell.getRow() * field.getCellSize(),
                            cell.getColumn() * field.getCellSize(),
                            this
                    );
                }
            }
        };

        fieldView.setPreferredSize(new Dimension(field.getNumberOfRows() * field.getCellSize(), field.getNumberOfColumns() * field.getCellSize()));
        window.add(fieldView);
    }

    private Image getImage(String name) {
        final String fileName = "../../img/" + name.toLowerCase() + ".png";
        final ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
        return icon.getImage();
    }
}
