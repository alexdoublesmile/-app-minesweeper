package alt.view.swing;

import alt.model.Cell;
import alt.model.Field;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private Field field;

    public GamePanel(Field field) {
        this.field = field;

        setPreferredSize(new Dimension(
                field.getNumberOfRows() * field.getCellSize(),
                field.getNumberOfColumns() * field.getCellSize()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Cell cell : field.getCellList()) {
            g.drawImage(
                    ImageHelper.getImageByType(CellImgType.getByCell(cell)),
                    cell.getRow() * field.getCellSize(),
                    cell.getColumn() * field.getCellSize(),
                    this
            );
        }
    }
}
