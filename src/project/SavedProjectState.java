package project;

import gui.MainCardManager;
import gui.dialog.DialogManager;

public class SavedProjectState extends ProjectState {

    @Override
    void createNewProject() {
        //TODO: DBCommunication.getListOfAllProjects()
        String[] listOfProjects = new String[]{"test_project_#1", "test_project_#2"};

        String validNewProjectName = DialogManager.getValidNewProjectName(listOfProjects);

        if (validNewProjectName == null) {
            return;
        }

        //TODO: DBCommunication.createNewProject(newProjectName)
        ProjectManager.setProjectState(new SavedProjectState());
    }

    @Override
    void saveCurrentProject() {}

    @Override
    void loadExistingProject() {
        //TODO: DBCommunication.getListOfAllProjects()
        String[] listOfProjects = new String[]{"test_project_#1", "test_project_#2"};

        DialogManager.choseExistingProjectDialog(listOfProjects);

        //TODO: DBCommunication.load()
        ProjectManager.setProjectState(new SavedProjectState());
    }

    @Override
    void closeCurrentProject() {
        ProjectManager.setProjectState(new NullProjectState());
        MainCardManager.changePanel(MainCardManager.MAIN_MENU_PANEL);
    }
}
