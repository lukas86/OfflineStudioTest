package project;

import gui.MainCardManager;
import gui.dialog.DialogManager;

public class SavedProjectState extends ProjectState {

    private static final boolean[] MENU_ENABLED_ARRAY = new boolean[] {true, true, false, true, true};

    public SavedProjectState(ProjectManager projectManager) {
        super(projectManager, MENU_ENABLED_ARRAY);
    }

    @Override
    void createNewProject() {
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
//        ProjectManager.setFrameTitle(ProjectManager.getProjectName() + " [saved]");
        projectManager.setProjectState(new SavedProjectState(projectManager));

        projectManager.setTitleStateToSaved();

        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    @Override
    void saveCurrentProject() {}

    @Override
    void loadExistingProject() {
        //TODO: DBCommunication.getListOfAllProjects()
        String[] listOfProjects = new String[]{"test_project_#1", "test_project_#2"};

        String chosenProjectName = DialogManager.choseExistingProjectDialog(listOfProjects);

        //TODO: DBCommunication.load()
        // ?
        // ProjectManager.load(chosenProjectName);

        projectManager.setProjectName(chosenProjectName);
//        ProjectManager.setFrameTitle(ProjectManager.getProjectName() + " [saved]");
        projectManager.setProjectState(new SavedProjectState(projectManager));

        projectManager.setTitleStateToSaved();

        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    @Override
    void closeCurrentProject() {
        //TODO:
        // ?
        // ProjectManager.closeCurrentProject();

        projectManager.setProjectName("");
//        ProjectManager.setFrameTitle(ProjectManager.getProjectName());
        projectManager.setProjectState(new NullProjectState(projectManager));

        projectManager.setTitleStateToNull();

        MainCardManager.changePanel(MainCardManager.MAIN_MENU_PANEL);
    }

    @Override
    boolean[] getMenuItemEnabledArray() {
        return MENU_ENABLED_ARRAY;
    }
}
