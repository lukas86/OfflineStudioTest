package project;

import gui.MainCardManager;
import gui.dialog.DialogManager;

public class UnsavedProjectState extends ProjectState {

    @Override
    void createNewProject() {
        //TODO: DBCommunication.getListOfAllProjects()
        String[] listOfProjects = new String[]{"test_project_#1", "test_project_#2"};

        if (DialogManager.showSaveDialog()) {
            //TODO: DBCommunication.saveProject();
            ProjectManager.setProjectState(new SavedProjectState());
        }

        String validNewProjectName = DialogManager.getValidNewProjectName(listOfProjects);

        if (validNewProjectName == null) {
            return;
        }

        //TODO: DBCommunication.createNewProject(newProjectName)
        ProjectManager.setProjectState(new SavedProjectState());
    }

    @Override
    void saveCurrentProject() {
        //TODO: DBCommunication.save()
        ProjectManager.setProjectState(new SavedProjectState());
    }

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
        if (DialogManager.showSaveDialog()) {
            //TODO: DBCommunication.save()
            ProjectManager.setProjectState(new SavedProjectState());
        }
        ProjectManager.setProjectState(new NullProjectState());
        MainCardManager.changePanel(MainCardManager.MAIN_MENU_PANEL);
    }
}
