import model.Box;
import model.Coord;
import util.Ranges;

import javax.swing.*;
import java.awt.*;

public class Start extends JFrame {

    private JPanel panel;
    private final int COLS = 9;
    private final int ROWS = 9;
    private final int IMAGE_SIZE = 50;

    public static void main(String[] args) {
        new Start();
    }

    private Start() {
        Ranges.setSize(new Coord(COLS, ROWS));
        setImages();
        initPanel();
        initFrame();
    }

    private void initFrame() {
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(getImage("icon"));
        setVisible(true);
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord : Ranges.getAllCoords()) {
                    g.drawImage(
                            (Image) Box.BOMB.image,
                            coord.getX()*IMAGE_SIZE,
                            coord.getY()*IMAGE_SIZE,
                            this
                    );
                }
            }
        };
        panel.setPreferredSize(new Dimension(Ranges.getSize().getX()*IMAGE_SIZE, Ranges.getSize().getY()*IMAGE_SIZE));
        add(panel);
    }

    private Image getImage(String name) {
        final String fileName = "img/" + name.toLowerCase() + ".png";
        final ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
        return icon.getImage();
    }

    private void setImages() {
        for (Box box : model.Box.values()) {
            box.image = getImage(box.name().toLowerCase());
        }
    }
}
