package view.swing;

import model.Field;
import util.CellUtil;

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
        CellUtil.getCellList(field.getCells()).forEach(cell ->
                g.drawImage(
                        ImageHelper.getImageByType(ImageType.getByCell(cell)),
                        cell.getRow() * field.getCellSize(),
                        cell.getColumn() * field.getCellSize(), this));
    }

    public void updateModel(Field field) {
        this.field = field;
    }
}