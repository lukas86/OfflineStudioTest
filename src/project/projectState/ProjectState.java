package project.projectState;

import gui.MainCardManager;
import gui.dialog.DialogManager;
import project.ProjectManager;
import repository.ProjectRepository;

public abstract class ProjectState {

    private final boolean[] menuEnabledArray;
    private final String description;

    ProjectManager projectManager;

    public ProjectState(ProjectManager projectManager,
                        boolean[] menuEnabledArray,
                        String description) {
        this.projectManager = projectManager;
        this.menuEnabledArray = menuEnabledArray;
        this.description = description;
    }

    public abstract void createNewProject();

    public abstract void saveCurrentProject();

    public abstract void loadExistingProject();

    public abstract void closeCurrentProject();

    public boolean[] getMenuItemEnabledArray() {
        return menuEnabledArray;
    }

    public String getDescription() {
        return description;
    }

    void create(String projectName) {
        DialogManager.showWaitingToCreateAlert(projectName);

        Thread thread = new Thread() {
            @Override
            public void run() {
                //TODO: ProjectManager.createNewProject(projectName);
                ProjectRepository.createNewProject(projectName);

                DialogManager.disposeOfWaitingDialog();

                load(projectName);
            }
        };
        thread.start();


    }

    void load(String projectName) {
        DialogManager.showWaitingToLoadAlert(projectName);

        Thread thread = new Thread() {
            @Override
            public void run() {

                //TODO: ProjectManager.load(chosenProjectName);
                ProjectRepository.getProject(projectName);

                projectManager.setProjectName(projectName);
                projectManager.setProjectState(new SavedProjectState(projectManager));
                MainCardManager.changePanel(MainCardManager.TABBED_PANEL);


                DialogManager.disposeOfWaitingDialog();
            }
        };
        thread.start();
    }

    void save() {
        DialogManager.showWaitingToSaveAlert("placeholder");

        Thread thread = new Thread() {
            @Override
            public void run() {
                //TODO:
                // ProjectManager.save();
                // ProjectRepository.saveProject();

                DialogManager.disposeOfWaitingDialog();

                load(projectManager.getProjectName());
            }
        };
        thread.start();
    }

    void close() {
        //TODO: ProjectManager.closeCurrentProject();

        projectManager.setProjectName("");
        projectManager.setProjectState(new NullProjectState(projectManager));
        MainCardManager.changePanel(MainCardManager.MAIN_MENU_PANEL);
    }

}
