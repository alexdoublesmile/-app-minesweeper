package view.swing.menu;

import lombok.Getter;
import view.SwingView;

import javax.swing.*;

@Getter
public class GameMenu extends JMenuBar {
    private final SwingView view;

    public GameMenu(SwingView view) {
        this.view = view;

        final JMenu gameMenu = new JMenu("Game");
        final JMenuItem newGame = new JMenuItem("Restart");
        newGame.addActionListener(new RestartAction(this));

        final JMenuItem saveGame = new JMenuItem("Save... ");
//        saveGame.addActionListener(new SaveAction());// TODO: 25.01.2023  
        final JMenuItem loadGame = new JMenuItem("Load... ");
//        loadGame.addActionListener(new LoadAction());// TODO: 25.01.2023  
        gameMenu.add(newGame);
        gameMenu.add(saveGame);
        gameMenu.add(loadGame);

        final JMenu optionsMenu = new JMenu("Options");
        final ButtonGroup buttonGroup = new ButtonGroup();
        final JRadioButtonMenuItem easy = new EasyComplexityButton("Easy", this);
        final JRadioButtonMenuItem medium = new NormalComplexityButton("Normal", this);
        final JRadioButtonMenuItem hard = new HardComplexityButton("Hard", this);
        buttonGroup.add(easy);
        buttonGroup.add(medium);
        buttonGroup.add(hard);
        final JMenuItem custom = new JMenuItem("Custom...");
//        custom.addActionListener(new CustomAction());// TODO: 25.01.2023

        JCheckBoxMenuItem autoOpen = new AutoOpenCheckBox("Enable auto-open by click", this);

        final JMenuItem topGame = new JMenuItem("TOP List");
//        topGame.addActionListener(new ToplistAction());// TODO: 25.01.2023  
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
        about.addActionListener(new AboutAction());
        helpMenu.add(about);

        add(gameMenu);
        add(optionsMenu);
        add(helpMenu);
    }
}
