package project;

import gui.MainFrame;
import gui.MainMenuBar;

public class ProjectManager {

    private final TitleManager titleManager = new TitleManager();
    private ProjectState projectState = new NullProjectState(this);
    private MainMenuBar mainMenuBar;

    private String projectName = "";

    public ProjectManager() {

    }

    public void create() {
        projectState.createNewProject();
    }

    public void save() {
        projectState.saveCurrentProject();
    }

    public void load() {
        projectState.loadExistingProject();
    }

    public void close() {
        projectState.closeCurrentProject();
    }

    public void exit() {
        close();
        System.exit(0);
    }

    public void setProjectState(ProjectState projectState) {
        this.projectState = projectState;

        mainMenuBar.setEnabled(projectState.getMenuItemEnabledArray());
        mainMenuBar.revalidate();

        titleManager.setStateDescription(projectState.getDescription());
    }

    public void setMainMenuBar(MainMenuBar mainMenuBar) {
        this.mainMenuBar = mainMenuBar;
    }

    public void setMainFrame(MainFrame mainFrame) {
        titleManager.setMainFrame(mainFrame);
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
        titleManager.setProjectName(projectName);
    }

    public String getProjectName() {
        return projectName;
    }

}
