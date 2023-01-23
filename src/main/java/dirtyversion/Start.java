package dirtyversion;

import dirtyversion.controller.Game;
import dirtyversion.model.Box;
import dirtyversion.model.Coord;
import dirtyversion.util.Ranges;
import dirtyversion.view.Panel;
import dirtyversion.view.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Start {

    private Game game;
    private Window window;
    private Panel panel;
    private JLabel label;
    private final int COLS = 9;
    private final int ROWS = 9;
    private final int IMAGE_SIZE = 50;
    private final int BOMB_NUMBERS = 10;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Start::new);
    }

    private Start() {
        game = new Game(COLS, ROWS, BOMB_NUMBERS);
        setImages();
        initLabel();
        initPanel();
        initFrame();
        game.start();
    }

    private void initLabel() {
        window = new Window("Minesweeper");
        label = new JLabel("Welcome");
        window.add(label, BorderLayout.SOUTH);
    }

    private void initFrame() {
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setIconImage(getImage("icon"));
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private void initPanel() {
        panel = new Panel() {
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
                label.setText(getMessage());
                panel.repaint();

            }
        });

        panel.setPreferredSize(new Dimension(Ranges.getSize().getX()*IMAGE_SIZE, Ranges.getSize().getY()*IMAGE_SIZE));
        window.add(panel);
    }

    private String getMessage() {
        switch (game.getState()) {
            case PLAYED: return "Think twice!";
            case BOMBED: return "BOOM!";
            case WINNER: return "Congratulations!";
            default: return "Welcome!";
        }
    }

    private Image getImage(String name) {
        final String fileName = "../img/" + name.toLowerCase() + ".png";
        final ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
        return icon.getImage();
    }

    private void setImages() {
        for (Box box : Box.values()) {
            box.image = getImage(box.name().toLowerCase());
        }
    }
}
