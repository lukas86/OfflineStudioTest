package project;

public abstract class ProjectState {

    abstract void createNewProject();
    abstract void saveCurrentProject();
    abstract void loadExistingProject();
    abstract void closeCurrentProject();

    abstract boolean[] getMenuItemEnabledArray();

}
