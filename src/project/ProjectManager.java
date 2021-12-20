package project;

import gui.MainFrame;
import gui.MainMenuBar;
import project.projectState.ProjectStateManager;

import javax.swing.*;

public class ProjectManager {

    private final ProjectStateManager projectStateManager = new ProjectStateManager();
    private final TitleManager titleManager = new TitleManager();
    private ProjectState projectState = new NullProjectState(this);
    private MainMenuBar mainMenuBar;

    public ProjectManager() {

    }

    private String projectName = "";

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
        projectState = projectState;
        mainMenuBar.setEnabled(projectState.getMenuItemEnabledArray());
        mainMenuBar.revalidate();
    }

    public void setMainMenuBar(MainMenuBar mainMenuBar) {
        mainMenuBar = mainMenuBar;
    }


    //TODO: to nekako počisti

    public void setMainFrame(MainFrame mainFrame) {
        titleManager.setMainFrame(mainFrame);
    }

    public void setProjectName(String projectName) {
        ProjectManager.projectName = projectName;
        titleManager.setProjectName(projectName);
    }

    public String getProjectName() {
        return projectName;
    }


    public void clearTitle() {
        titleManager.clear();
    }

    public void saveTitle() {
        titleManager.save();
    }

}
