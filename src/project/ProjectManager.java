package project;

import gui.MainCardManager;
import gui.dialog.DialogManager;

public class ProjectManager {

    private final static Project currentProject = new Project();
    private static ProjectState projectState = ProjectState.NULL;

    public static void createNewProject() {
        //TODO: refactor -> projectState = projectState.create();
        //TODO: DBCommunication.getListOfAllProjects()
        //TODO: DBCommunication.createNewProject()
        if(currentProject.getState() == ProjectState.NULL) {
            DialogManager.provideProjectNameDialog();
            currentProject.setState(ProjectState.SAVED);
        } else if(currentProject.getState() == ProjectState.UNSAVED) {
            DialogManager.showSaveDialog();
            currentProject.setState(ProjectState.SAVED);
        }
        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    public static void saveCurrentProject() {
        //TODO: refactor -> projectState = projectState.save();
        //TODO: DBCommunication.save()
        currentProject.setState(ProjectState.SAVED);
    }

    public static void loadExistingProject() {
        //TODO: refactor -> projectState = projectState.load();
        //TODO: DBCommunication.getListOfAllProjects()
        //TODO: DBCommunication.load()
        DialogManager.choseExistingProjectDialog();
        currentProject.setState(ProjectState.SAVED);
    }

    public static void closeCurrentProject() {
        //TODO: refactor -> projectState = projectState.close();
        if(currentProject.getState() == ProjectState.UNSAVED) {
            DialogManager.showSaveDialog();
            currentProject.setState(ProjectState.UNSAVED);
        }
        MainCardManager.changePanel(MainCardManager.MAIN_MENU_PANEL);
    }

}
