package view.swing.panel;

import model.Field;
import util.CellUtil;
import view.util.ImageHelper;
import view.util.ImageType;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Field field;

    public GamePanel(Field field) {
        this.field = field;

        setPreferredSize(new Dimension(
                field.getColumnsNumber() * field.getCellSize(),
                field.getRowsNumber() * field.getCellSize()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        CellUtil.getCellList(field.getCells()).forEach(cell ->
                g.drawImage(
                        ImageHelper.getImageByType(ImageType.getByCell(cell)),
                        cell.getColumn() * field.getCellSize(),
                        cell.getRow() * field.getCellSize(),
                        this));
    }

    public void updateModelInView(Field field) {
        this.field = field;
    }
}
