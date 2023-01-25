package view;

import javax.swing.*;

public class GameMenu extends JMenuBar {
    public GameMenu() {
        final JMenu gameMenu = new JMenu("Game");
        final JMenuItem newGame = new JMenuItem("Restart");
        final JMenuItem saveGame = new JMenuItem("Save... ");
        final JMenuItem loadGame = new JMenuItem("Load... ");
        gameMenu.add(newGame);
        gameMenu.add(saveGame);
        gameMenu.add(loadGame);

        final JMenu optionsMenu = new JMenu("Options");
        final ButtonGroup buttonGroup = new ButtonGroup();
        final JRadioButtonMenuItem easy = new JRadioButtonMenuItem("Easy", true);
        final JRadioButtonMenuItem medium = new JRadioButtonMenuItem("Medium", false);
        final JRadioButtonMenuItem hard = new JRadioButtonMenuItem("Hard", false);
        buttonGroup.add(easy);
        buttonGroup.add(medium);
        buttonGroup.add(hard);
        final JMenuItem custom = new JMenuItem("Custom...");
        final JCheckBoxMenuItem autoOpen = new JCheckBoxMenuItem("Enable auto open by click", true);
        final JMenuItem topGame = new JMenuItem("TOP List");
        optionsMenu.add(easy);
        optionsMenu.add(medium);
        optionsMenu.add(hard);
        optionsMenu.add(custom);
        optionsMenu.add(new JSeparator());
        optionsMenu.add(autoOpen);
        optionsMenu.add(new JSeparator());
        optionsMenu.add(topGame);

        final JMenu helpMenu = new JMenu("Help");
        final JMenuItem about = new JMenuItem("About");
        helpMenu.add(about);

        add(gameMenu);
        add(optionsMenu);
        add(helpMenu);
    }
}
