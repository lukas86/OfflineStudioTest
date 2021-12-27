package project;

import gui.MainCardManager;
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

    boolean[] getMenuItemEnabledArray() {
        return menuEnabledArray;
    }

    String getDescription() {   return description;   };

    void create(String validNewProjectName) {
        //TODO: ProjectManager.createNewProject(validNewProjectName);
        ProjectRepository.createNewProject(validNewProjectName);

        load(validNewProjectName);
    }

    void load(String chosenProjectName) {
        //TODO:
        // ProjectManager.load(chosenProjectName);
        // ProjectRepository.load(chosenProjectName);

        projectManager.setProjectName(chosenProjectName);
        projectManager.setProjectState(new SavedProjectState(projectManager));
        MainCardManager.changePanel(MainCardManager.TABBED_PANEL);
    }

    void save() {
        //TODO:
        // ProjectManager.save();
        // ProjectRepository.saveProject();

        load(projectManager.getProjectName());
    }

    public void close() {
        //TODO: ProjectManager.closeCurrentProject();

        projectManager.setProjectName("");
        projectManager.setProjectState(new NullProjectState(projectManager));
        MainCardManager.changePanel(MainCardManager.MAIN_MENU_PANEL);
    }

}
