package view.swing.panel;

import controller.GameController;
import model.ModelInfo;
import view.util.ImageHelper;
import view.util.ImageType;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private GameController controller;
    private ModelInfo modelInfo;
    private BombLabel bombLabel;

    public GamePanel(GameController controller, BombLabel bombLabel) {
        this.controller = controller;
        this.bombLabel = bombLabel;

        modelInfo = controller.getModelInfo();

        setPreferredSize(new Dimension(
                modelInfo.getColumnsNumber() * modelInfo.getCellSize(),
                modelInfo.getRowsNumber() * modelInfo.getCellSize()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        modelInfo = controller.getModelInfo();
//        bombLabel.setText(String.valueOf(modelInfo.getBombsNumber() - modelInfo.getFlagsNumber()));

        modelInfo.getCellList().forEach(cell ->
                g.drawImage(
                        ImageHelper.getImageByType(ImageType.getByCell(cell)),
                        cell.getColumn() * modelInfo.getCellSize(),
                        cell.getRow() * modelInfo.getCellSize(),
                        this));
    }
}
