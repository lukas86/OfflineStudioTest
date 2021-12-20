package gui;

import gui.dialog.DialogManager;
import project.NullProjectState;
import project.ProjectManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

    private static final String OFFLINE_STUDIO_3000 = "Offline Studio 3000";

    private static final int WIDTH = 960;
    private static final int HEIGHT = 640;

    public MainFrame() {
        DialogManager.setFrame(this);

        MainMenuBar mainMenuBar = new MainMenuBar();

        ProjectManager projectManager = new ProjectManager();
        projectManager.setMainMenuBar(mainMenuBar);
        projectManager.setMainFrame(this);
        projectManager.setProjectState(new NullProjectState(projectManager));

        this.setJMenuBar(mainMenuBar);
        this.add(MainCardManager.getMainPanel());

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

//    public void setProjectNameInTitle(String activeProjectName) {
//        setTitle(OFFLINE_STUDIO_3000 + " - " + activeProjectName);
//    }

    //TODO: dodatne metode za stanje -> ločen klass?
    // NullState -> OFFLINE_STUDIO_3000 ""
    // UnsavedState -> OFFLINE_STUDIO_3000 - "project_name" [unsaved]
    // SavedState ->  OFFLINE_STUDIO_3000 - "project_name" [saved]

}
