import model.Box;

import javax.swing.*;
import java.awt.*;

public class Start extends JFrame {

    private JPanel panel;
    private final int COLS = 15;
    private final int ROWS = 1;
    private final int IMAGE_SIZE = 50;

    public static void main(String[] args) {
        new Start();
    }

    private Start() {
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
        setVisible(true);
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Box box : Box.values()) {
                    g.drawImage(
                            (Image) box.image, IMAGE_SIZE * box.ordinal(), 0, this);
                }
            }
        };
        panel.setPreferredSize(new Dimension(COLS*IMAGE_SIZE, ROWS*IMAGE_SIZE));
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
