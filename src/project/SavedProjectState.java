package project;

import gui.dialog.DialogManager;
import repository.ProjectRepository;

public class SavedProjectState extends ProjectState {

    private static final boolean[] MENU_ENABLED_ARRAY = new boolean[] {true, true, false, true, true};

    private static final String STATE_DESCRIPTION = " [saved]";

    public SavedProjectState(ProjectManager projectManager) {
        super(projectManager, MENU_ENABLED_ARRAY, STATE_DESCRIPTION);
    }

    @Override
    public void createNewProject() {
        String validNewProjectName = DialogManager.getValidNewProjectName(
                ProjectRepository.getListOfProjects());

        if (validNewProjectName == null) {
            return;
        }

        create(validNewProjectName);
    }

    @Override
    public void saveCurrentProject() {}

    @Override
    public void loadExistingProject() {
        String chosenProjectName = DialogManager.choseExistingProjectDialog(
                ProjectRepository.getListOfProjects());

        if(chosenProjectName == null) {
            return;
        }
        load(chosenProjectName);

    }
    @Override
    public void closeCurrentProject() {
        close();
    }
}
