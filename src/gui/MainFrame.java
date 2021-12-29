package gui;

import gui.dialog.DialogManager;
import project.projectState.NullProjectState;
import project.ProjectManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

    private static final int WIDTH = 960;
    private static final int HEIGHT = 640;

    MainCardManager mainCardManager;

    public MainFrame() {
        DialogManager.setFrame(this);

        MainMenuBar mainMenuBar = new MainMenuBar();

        ProjectManager projectManager = new ProjectManager();

        mainMenuBar.setProjectManager(projectManager);

        projectManager.setMainMenuBar(mainMenuBar);
        projectManager.setMainFrame(this);
        projectManager.setProjectState(new NullProjectState(projectManager));

        this.setJMenuBar(mainMenuBar);
        mainCardManager = new MainCardManager(projectManager);

        this.add(mainCardManager.getMainPanel());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){projectManager.exit();
            }
        });
//        mainFrame.setLocationRelativeTo(null);
        //TODO: set Icon
        this.setIconImage(null);
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(null);
        this.pack();
        this.setVisible(true);
    }

}
