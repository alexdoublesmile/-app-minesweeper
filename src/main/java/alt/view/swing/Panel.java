package alt.view.swing;

import alt.model.Cell;
import alt.model.CellImgType;
import alt.model.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Panel extends JPanel {

    private Field field;

    public Panel(Field field) {
        this.field = field;

        setPreferredSize(new Dimension(
                field.getNumberOfRows() * field.getCellSize(),
                field.getNumberOfColumns() * field.getCellSize()));
        initListeners();
    }

    private void initListeners() {
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                int row = e.getX() / field.getCellSize();
//                int col = e.getY() / field.getCellSize();
//                if (e.getButton() == MouseEvent.BUTTON1) {
//                    controller.pressLeftButton(row, col);
//                }
//                if (e.getButton() == MouseEvent.BUTTON3) {
//                    controller.pressRightButton(row, col);
//                }
////                if (e.getButton() == MouseEvent.BUTTON2) {
////                    controller.start();
////                }
////                label.setText(getMessage());
//                repaint();
//
//            }
//        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        final List<Cell> cells = Stream.of(field.getCells())
                .flatMap(Arrays::stream)
                .collect(toList());

        super.paintComponent(g);
        for (Cell cell : cells) {
            g.drawImage(
                    ImageHelper.getImageByType(CellImgType.getByCell(cell)),
                    cell.getRow() * field.getCellSize(),
                    cell.getColumn() * field.getCellSize(),
                    this
            );
        }
    }
}
