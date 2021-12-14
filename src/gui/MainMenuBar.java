package gui;

import project.ProjectManager;

import javax.swing.*;

public class MainMenuBar extends JMenuBar {
    public MainMenuBar() {
        JMenu projectMenu = new JMenu("Project");

        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(e -> {
            ProjectManager.createNewProject();
        });
        JMenuItem loadMenuItem = new JMenuItem("Load");
        loadMenuItem.addActionListener(e -> {
            ProjectManager.loadExistingProject();
        });

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(e -> {
            ProjectManager.saveCurrentProject();
        });

        JMenuItem closeMenuItem = new JMenuItem("Close");
        closeMenuItem.addActionListener(e -> {
            ProjectManager.closeCurrentProject();
        });

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> {
//            ProjectManager.closeCurrentProject();
//            System.exit(0);
            ProjectManager.exit();
        });

        projectMenu.add(newMenuItem);
        projectMenu.add(loadMenuItem);
        projectMenu.add(saveMenuItem);
        projectMenu.add(closeMenuItem);
        projectMenu.add(new JSeparator());
        projectMenu.add(exitMenuItem);

        add(projectMenu);
    }
}
