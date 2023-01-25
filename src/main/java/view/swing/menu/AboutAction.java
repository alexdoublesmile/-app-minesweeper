package view.swing.menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.util.ViewConstants.VERSION_MESSAGE_TEXT;
import static view.util.ViewConstants.VERSION_MESSAGE_TITLE;

public class AboutAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(
                null,
                VERSION_MESSAGE_TEXT,
                VERSION_MESSAGE_TITLE,
                JOptionPane.INFORMATION_MESSAGE);
    }
}
