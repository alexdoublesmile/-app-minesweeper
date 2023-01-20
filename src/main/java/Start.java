import controller.Game;
import model.Box;
import model.Coord;
import util.Ranges;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Start extends JFrame {

    private Game game;
    private JPanel panel;
    private final int COLS = 9;
    private final int ROWS = 9;
    private final int IMAGE_SIZE = 50;
    private final int BOMB_NUMBERS = 10;

    public static void main(String[] args) {
        new Start();
    }

    private Start() {
        game = new Game(COLS, ROWS, BOMB_NUMBERS);
        setImages();
        initPanel();
        initFrame();
        game.start();
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(getImage("icon"));
        pack();
        setVisible(true);
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord : Ranges.getAllCoords()) {
                    g.drawImage(
                            (Image) game.getBox(coord).image,
                            coord.getX()*IMAGE_SIZE,
                            coord.getY()*IMAGE_SIZE,
                            this
                    );
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / IMAGE_SIZE;
                int y = e.getY() / IMAGE_SIZE;
                final Coord coord = new Coord(x, y);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    game.pressLeftButton(coord);
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    game.pressRightButton(coord);
                }
                if (e.getButton() == MouseEvent.BUTTON2) {
                    game.start();
                }
                panel.repaint();
            }
        });

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
