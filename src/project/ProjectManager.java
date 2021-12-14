package project;

import gui.MainMenuBar;

public class ProjectManager {

    private final static Project currentProject = new Project();
    private static ProjectState projectState = new NullProjectState();
    private static MainMenuBar mainMenuBar;

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
}
