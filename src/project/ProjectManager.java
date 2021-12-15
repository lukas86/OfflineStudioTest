package project;

import gui.MainFrame;
import gui.MainMenuBar;

import javax.swing.*;

public class ProjectManager {

//    private final static Project currentProject = new Project();
    private static ProjectState projectState = new NullProjectState();
    private static MainMenuBar mainMenuBar;
    private static JFrame mainFrame;

    private static String projectName = "";

    public static void createNewProject() {
        projectState.createNewProject();
    }

    public static void saveCurrentProject() {
        projectState.saveCurrentProject();
    }

    public static void loadExistingProject() {
        projectState.loadExistingProject();
    }

    public static void closeCurrentProject() {
        projectState.closeCurrentProject();
    }

    public static void exit() {
        ProjectManager.closeCurrentProject();
        System.exit(0);
    }

    public static void setProjectState(ProjectState projectState) {
        ProjectManager.projectState = projectState;
        mainMenuBar.setEnabled(projectState.getMenuItemEnabledArray());
        mainMenuBar.revalidate();
    }

    public static void setMainMenuBar(MainMenuBar mainMenuBar) {
        ProjectManager.mainMenuBar = mainMenuBar;
    }

    public static void setFrameTitle(String projectName) {
        mainFrame.setTitle("Offline Studio 3000 - " + projectName);
    }

    public static void setMainFrame(MainFrame mainFrame) {
        ProjectManager.mainFrame = mainFrame;
    }

    public static void setProjectName(String projectName) {
        ProjectManager.projectName = projectName;
    }

    public static String getProjectName() {
        return projectName;
    }
}
