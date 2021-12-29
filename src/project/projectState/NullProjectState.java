package project.projectState;

import gui.dialog.DialogManager;
import project.ProjectManager;
import repository.ProjectRepository;

public class NullProjectState extends ProjectState {

    private static final boolean[] MENU_ENABLED_ARRAY = new boolean[] {true, true, false, false, true};

    public static final String STATE_DESCRIPTION = "";

    public NullProjectState(ProjectManager projectManager) {
        super(projectManager, MENU_ENABLED_ARRAY, STATE_DESCRIPTION);
    }

    @Override
    public void createNewProject() {
        String validNewProjectName = DialogManager.getValidNewProjectName(
                ProjectRepository.getListOfProjects());

        if(validNewProjectName == null) {
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
    public void closeCurrentProject() {}
}
