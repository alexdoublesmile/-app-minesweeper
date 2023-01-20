import javax.swing.*;

public class Start extends JFrame {
    public static void main(String[] args) {
        new Start();
    }

    private Start() {
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
}
