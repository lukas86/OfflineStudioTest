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
        newMenuItem.addActionListener(e -> ProjectManager.createNewProject());

        loadMenuItem = new JMenuItem("Load");
        loadMenuItem.addActionListener(e -> ProjectManager.loadExistingProject());

        saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(e -> ProjectManager.saveCurrentProject());

        closeMenuItem = new JMenuItem("Close");
        closeMenuItem.addActionListener(e -> ProjectManager.closeCurrentProject());

        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> ProjectManager.exit());

        projectMenu.add(newMenuItem);
        projectMenu.add(loadMenuItem);
        projectMenu.add(saveMenuItem);
        projectMenu.add(closeMenuItem);
        projectMenu.add(new JSeparator());
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
