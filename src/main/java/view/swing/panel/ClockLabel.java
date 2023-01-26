package view.swing.panel;

import view.SwingView;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockLabel extends JLabel {
    private final SwingView view;

        public ClockLabel(SwingView view) {
            this.view = view;

            setText(view.getController().getBombsNumber() + "");
//            setForeground(Color.BLACK);
//            setFont(new Font("sans-serif", Font.ROMAN_BASELINE, 24));
            setHorizontalAlignment(SwingConstants.LEFT);

//            Timer t = new Timer(1000, e -> setText(new SimpleDateFormat("hh:mm:ss a").format(new Date())));
//            t.start();
        }
}
