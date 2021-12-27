package project;

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

    abstract void createNewProject();
    abstract void saveCurrentProject();
    abstract void loadExistingProject();
    abstract void closeCurrentProject();

    boolean[] getMenuItemEnabledArray() {
        return menuEnabledArray;
    }

    String getDescription() {   return description;   };

}
