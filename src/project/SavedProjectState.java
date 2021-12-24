package project;

import DB.DBCommunication;
import gui.MainCardManager;
import gui.dialog.DialogManager;

public class SavedProjectState extends ProjectState {

    private static final boolean[] MENU_ENABLED_ARRAY = new boolean[] {true, true, false, true, true};

    private static final String STATE_DESCRIPTION = " [saved]";

    public SavedProjectState(ProjectManager projectManager) {
        super(projectManager, MENU_ENABLED_ARRAY, STATE_DESCRIPTION);
    }

    @Override
    void createNewProject() {
        String validNewProjectName = DialogManager.getValidNewProjectName(
                DBCommunication.getListOfProjects());

        if (validNewProjectName == null) {
            return;
        }

        // TODO: ProjectManager.createNewProject(validNewProjectName);
        DBCommunication.createNewProject(validNewProjectName);

        projectManager.setProjectName(validNewProjectName);
        projectManager.setProjectState(new SavedProjectState(projectManager));
        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    @Override
    void saveCurrentProject() {}

    @Override
    void loadExistingProject() {
        String chosenProjectName = DialogManager.choseExistingProjectDialog(
                DBCommunication.getListOfProjects());

        //TODO: DBCommunication.load()
        // ProjectManager.load(chosenProjectName);

        projectManager.setProjectName(chosenProjectName);
        projectManager.setProjectState(new SavedProjectState(projectManager));
        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    @Override
    void closeCurrentProject() {
        //TODO:
        // ProjectManager.closeCurrentProject();

        projectManager.setProjectName("");
        projectManager.setProjectState(new NullProjectState(projectManager));
        MainCardManager.changePanel(MainCardManager.MAIN_MENU_PANEL);
    }
}
