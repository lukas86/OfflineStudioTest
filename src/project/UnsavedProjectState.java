package project;

import DB.DBCommunication;
import gui.MainCardManager;
import gui.dialog.DialogManager;

public class UnsavedProjectState extends ProjectState {

    private static final boolean[] MENU_ENABLED_ARRAY = new boolean[] {true, true, true, true, true};

    public static final String STATE_DESCRIPTION = " [not saved]";

    public UnsavedProjectState(ProjectManager projectManager) {
        super(projectManager, MENU_ENABLED_ARRAY, STATE_DESCRIPTION);
    }

    @Override
    void createNewProject() {

        if (DialogManager.showSaveDialog()) {
            //TODO: DBCommunication.saveProject();
            // ProjectManager.save();

            projectManager.setProjectName(projectManager.getProjectName());
            projectManager.setProjectState(new SavedProjectState(projectManager));
            MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
        }

        String validNewProjectName = DialogManager.getValidNewProjectName(
                DBCommunication.getListOfProjects());

        if (validNewProjectName == null) {
            return;
        }

        //TODO: DBCommunication.createNewProject(newProjectName)
        // ProjectManager.createNewProject(validNewProjectName);

        projectManager.setProjectName(validNewProjectName);
        projectManager.setProjectState(new SavedProjectState(projectManager));
        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    @Override
    void saveCurrentProject() {
        //TODO: DBCommunication.save()
        // ProjectManager.saveProject();

        projectManager.setProjectName(projectManager.getProjectName());
        projectManager.setProjectState(new SavedProjectState(projectManager));
        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    @Override
    void loadExistingProject() {

        //TODO: what about cancel
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
        if (DialogManager.showSaveDialog()) {
            //TODO: DBCommunication.save()
            // ProjectManager.save();

            projectManager.setProjectName(projectManager.getProjectName());
            projectManager.setProjectState(new SavedProjectState(projectManager));
            MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
        }

        // TODO: ProjectManager.closeCurrentProject();

        projectManager.setProjectName("");
        projectManager.setProjectState(new NullProjectState(projectManager));
        MainCardManager.changePanel(MainCardManager.MAIN_MENU_PANEL);
    }
}
