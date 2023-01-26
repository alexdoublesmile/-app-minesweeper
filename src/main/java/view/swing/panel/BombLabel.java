package view.swing.panel;

import model.ModelInfo;
import view.SwingView;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BombLabel extends JLabel {
    private final SwingView view;

        public BombLabel(SwingView view) {
            this.view = view;


            setHorizontalAlignment(SwingConstants.LEFT);


//            setForeground(Color.BLACK);
//            setFont(new Font("sans-serif", Font.ROMAN_BASELINE, 24));

//            Timer t = new Timer(1000, e -> setText(new SimpleDateFormat("hh:mm:ss a").format(new Date())));
//            t.start();
        }
}
