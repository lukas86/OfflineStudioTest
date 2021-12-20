package project;

import gui.MainCardManager;
import gui.dialog.DialogManager;

public class NullProjectState extends ProjectState {

    private static final boolean[] MENU_ENABLED_ARRAY = new boolean[] {true, true, false, false, true};

    public NullProjectState(ProjectManager projectManager) {
        super(projectManager, MENU_ENABLED_ARRAY);
    }

    @Override
    public void createNewProject() {
        //TODO: DBCommunication.getListOfAllProjects()
        String[] listOfProjects = new String[]{"test_project_#1", "test_project_#2"};

        String validNewProjectName = DialogManager.getValidNewProjectName(listOfProjects);

        if(validNewProjectName == null) {
            return;
        }

        //TODO: DBCommunication.createNewProject(newProjectName)
        // ?
        // ProjectManager.createNewProject(validNewProjectName);
        ProjectManager.setProjectName(validNewProjectName);
//        ProjectManager.setFrameTitle(ProjectManager.getProjectName() + " [saved]");
        ProjectManager.saveTitle();

        ProjectManager.setProjectState(new SavedProjectState(projectManager));

        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    @Override
    public void saveCurrentProject() {}

    @Override
    public void loadExistingProject() {
        //TODO: DBCommunication.getListOfAllProjects()
        String[] listOfProjects = new String[]{"test_project_#1", "test_project_#2"};

        String chosenProjectName = DialogManager.choseExistingProjectDialog(listOfProjects);

        //TODO: DBCommunication.load()
        // ?
        // ProjectManager.load(chosenProjectName);
        ProjectManager.setProjectName(chosenProjectName);

//        ProjectManager.setFrameTitle(ProjectManager.getProjectName() + " [saved]");
        ProjectManager.saveTitle();

        ProjectManager.setProjectState(new SavedProjectState(projectManager));
        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    @Override
    public void closeCurrentProject() {}

//    @Override
//    boolean[] getMenuItemEnabledArray() {
//        return menuEnabledArray;
//    }
}
