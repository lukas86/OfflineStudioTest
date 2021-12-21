package project;

import gui.MainCardManager;
import gui.dialog.DialogManager;

public class UnsavedProjectState extends ProjectState {

    private static final boolean[] MENU_ENABLED_ARRAY = new boolean[] {true, true, true, true, true};

    public UnsavedProjectState(ProjectManager projectManager) {
        super(projectManager, MENU_ENABLED_ARRAY);
    }

    @Override
    void createNewProject() {

        if (DialogManager.showSaveDialog()) {
            //TODO: DBCommunication.saveProject();
            // ?
            // ProjectManager.save();

            projectManager.setProjectName(projectManager.getProjectName());

            projectManager.setProjectState(new SavedProjectState(projectManager));

            projectManager.setTitleStateToSaved();

            MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
        }

        //TODO: DBCommunication.getListOfAllProjects()
        String[] listOfProjects = new String[]{"test_project_#1", "test_project_#2"};

        String validNewProjectName = DialogManager.getValidNewProjectName(listOfProjects);

        if (validNewProjectName == null) {
            return;
        }

        //TODO: DBCommunication.createNewProject(newProjectName)
        // ?
        // ProjectManager.createNewProject(validNewProjectName);

        projectManager.setProjectName(validNewProjectName);

        projectManager.setProjectState(new SavedProjectState(projectManager));

        projectManager.setTitleStateToSaved();

        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    @Override
    void saveCurrentProject() {
        //TODO: DBCommunication.save()
        // ?
        // ProjectManager.saveProject();

        projectManager.setProjectName(projectManager.getProjectName());

        projectManager.setProjectState(new SavedProjectState(projectManager));

        projectManager.setTitleStateToSaved();

        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    @Override
    void loadExistingProject() {
        //TODO: DBCommunication.getListOfAllProjects()
        String[] listOfProjects = new String[]{"test_project_#1", "test_project_#2"};

        String chosenProjectName = DialogManager.choseExistingProjectDialog(listOfProjects);

        //TODO: DBCommunication.load()
        // ?
        // ProjectManager.load(chosenProjectName);

        projectManager.setProjectName(chosenProjectName);

        projectManager.setProjectState(new SavedProjectState(projectManager));

        projectManager.setTitleStateToSaved();

        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    @Override
    void closeCurrentProject() {
        if (DialogManager.showSaveDialog()) {
            //TODO: DBCommunication.save()
            // ?
            // ProjectManager.save();

            projectManager.setProjectName(projectManager.getProjectName());

            projectManager.setProjectState(new SavedProjectState(projectManager));

            projectManager.setTitleStateToSaved();

            MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
        }

        //TODO:
        // ?
        // ProjectManager.closeCurrentProject();

        projectManager.setProjectName("");

        projectManager.setProjectState(new NullProjectState(projectManager));

        projectManager.setTitleStateToNull();

        MainCardManager.changePanel(MainCardManager.MAIN_MENU_PANEL);
    }

    @Override
    boolean[] getMenuItemEnabledArray() {
        return MENU_ENABLED_ARRAY;
    }
}
