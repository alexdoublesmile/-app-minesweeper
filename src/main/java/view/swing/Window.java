package view.swing;

import view.util.ImageConstants;
import view.util.ImageHelper;
import view.util.ViewConstants;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() throws HeadlessException {
        super();
        setTitle(ViewConstants.VIEW_TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(ImageHelper.getImageByName(ImageConstants.ICON_NAME));
        setVisible(true);
    }
}
