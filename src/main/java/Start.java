import javax.swing.*;
import java.awt.*;

public class Start extends JFrame {

    private JPanel panel;

    public static void main(String[] args) {
        new Start();
    }

    private Start() {
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
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
        add(panel);
    }
}
