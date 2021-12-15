package project;

import gui.MainCardManager;
import gui.dialog.DialogManager;

public class UnsavedProjectState extends ProjectState {

    private final boolean[] menuEnabledArray = new boolean[] {true, true, true, true, true};

    @Override
    void createNewProject() {

        if (DialogManager.showSaveDialog()) {
            //TODO: DBCommunication.saveProject();
            // ?
            // ProjectManager.save();
            ProjectManager.setFrameTitle(ProjectManager.getProjectName() + " [saved]");

            ProjectManager.setProjectState(new SavedProjectState());

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
        ProjectManager.setProjectName(validNewProjectName);
        ProjectManager.setFrameTitle(ProjectManager.getProjectName() + " [saved]");

        ProjectManager.setProjectState(new SavedProjectState());

        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    @Override
    void saveCurrentProject() {
        //TODO: DBCommunication.save()
        // ?
        // ProjectManager.saveProject();
        ProjectManager.setFrameTitle(ProjectManager.getProjectName() + " [unsaved]");

        ProjectManager.setProjectState(new SavedProjectState());

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
        ProjectManager.setProjectName(chosenProjectName);

        ProjectManager.setFrameTitle(ProjectManager.getProjectName() + " [saved]");

        ProjectManager.setProjectState(new SavedProjectState());
        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    @Override
    void closeCurrentProject() {
        if (DialogManager.showSaveDialog()) {
            //TODO: DBCommunication.save()
            // ?
            // ProjectManager.save();

            ProjectManager.setFrameTitle(ProjectManager.getProjectName() + " [saved]");
            ProjectManager.setProjectState(new SavedProjectState());
            MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
        }

        //TODO:
        // ?
        // ProjectManager.closeCurrentProject();
        ProjectManager.setProjectName("");

        ProjectManager.setProjectState(new NullProjectState());
        ProjectManager.setFrameTitle(ProjectManager.getProjectName());
        MainCardManager.changePanel(MainCardManager.MAIN_MENU_PANEL);
    }

    @Override
    boolean[] getMenuItemEnabledArray() {
        return menuEnabledArray;
    }
}
