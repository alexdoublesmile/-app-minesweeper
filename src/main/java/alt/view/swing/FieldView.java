package alt.view.swing;

import alt.model.Cell;
import alt.model.CellImgType;
import alt.model.Field;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FieldView extends JPanel {

    private Field field;

    public FieldView(Field field) {
        this.field = field;
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
