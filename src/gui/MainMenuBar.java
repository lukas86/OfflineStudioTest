package gui;

import project.ProjectManager;

import javax.swing.*;

public class MainMenuBar extends JMenuBar {
    JMenuItem newMenuItem;
    JMenuItem loadMenuItem;
    JMenuItem saveMenuItem;
    JMenuItem closeMenuItem;
    JMenuItem exitMenuItem;

    public MainMenuBar() {
        JMenu projectMenu = new JMenu("Project");

        newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(e -> ProjectManager.create());
        projectMenu.add(newMenuItem);

        loadMenuItem = new JMenuItem("Load");
        loadMenuItem.addActionListener(e -> ProjectManager.load());
        projectMenu.add(loadMenuItem);

        saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(e -> ProjectManager.save());
        projectMenu.add(saveMenuItem);

        closeMenuItem = new JMenuItem("Close");
        closeMenuItem.addActionListener(e -> ProjectManager.close());
        projectMenu.add(closeMenuItem);

        projectMenu.add(new JSeparator());

        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> ProjectManager.exit());
        projectMenu.add(exitMenuItem);

        add(projectMenu);
    }

    public void setEnabled(boolean[] enabledArray) {
        newMenuItem.setEnabled(enabledArray[0]);
        loadMenuItem.setEnabled(enabledArray[1]);
        saveMenuItem.setEnabled(enabledArray[2]);
        closeMenuItem.setEnabled(enabledArray[3]);
        exitMenuItem.setEnabled(enabledArray[4]);
    }
}
