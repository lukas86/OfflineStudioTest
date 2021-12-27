package project;

import DB.DBCommunication;
import gui.MainCardManager;
import gui.dialog.DialogManager;

public class NullProjectState extends ProjectState {

    private static final boolean[] MENU_ENABLED_ARRAY = new boolean[] {true, true, false, false, true};

    public static final String STATE_DESCRIPTION = "";

    public NullProjectState(ProjectManager projectManager) {
        super(projectManager, MENU_ENABLED_ARRAY, STATE_DESCRIPTION);
    }

    @Override
    public void createNewProject() {
        String validNewProjectName = DialogManager.getValidNewProjectName(DBCommunication.getListOfProjects());

        if(validNewProjectName == null) {
            return;
        }

        // TODO: ProjectManager.createNewProject(validNewProjectName);
        DBCommunication.createNewProject(validNewProjectName);

        projectManager.setProjectName(validNewProjectName);
        projectManager.setProjectState(new SavedProjectState(projectManager));
        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    @Override
    public void saveCurrentProject() {}

    @Override
    public void loadExistingProject() {
        String chosenProjectName = DialogManager.choseExistingProjectDialog(
                DBCommunication.getListOfProjects());

        // TODO: DBCommunication.load()
        // ProjectManager.load(chosenProjectName);

        projectManager.setProjectName(chosenProjectName);
        projectManager.setProjectState(new SavedProjectState(projectManager));
        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    @Override
    public void closeCurrentProject() {}
}
