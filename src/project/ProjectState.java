package project;

public abstract class ProjectState {

    private boolean[] menuEnabledArray;
    ProjectManager projectManager;

    public ProjectState(ProjectManager projectManager, boolean[] menuEnabledArray) {
        this.projectManager = projectManager;
        this.menuEnabledArray = menuEnabledArray;
    }

    abstract void createNewProject();
    abstract void saveCurrentProject();
    abstract void loadExistingProject();
    abstract void closeCurrentProject();

    boolean[] getMenuItemEnabledArray() {
        return menuEnabledArray;
    }

}
