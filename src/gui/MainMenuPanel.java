package gui;

import project.ProjectManager;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {

    ProjectManager projectManager;

    public MainMenuPanel(ProjectManager projectManager) {
        this.projectManager = projectManager;

        this.setLayout(new GridLayout(1, 3, 30, 30));
        this.setBackground(Color.CYAN);

        JButton newProjectButton = new JButton("Create New Project");
        newProjectButton.addActionListener(e -> projectManager.create());
        this.add(newProjectButton);

        JButton loadProjectButton = new JButton("Load Existing Project");
        loadProjectButton.addActionListener(e -> projectManager.load());
        this.add(loadProjectButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> projectManager.exit());
        this.add(exitButton);
    }
}

