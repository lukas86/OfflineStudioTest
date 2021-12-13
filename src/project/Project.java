package project;

public class Project {
    private ProjectState state = ProjectState.NULL;;

    public ProjectState getState() {
        return state;
    }

    public void setState(ProjectState state) {
        this.state = state;
    }
}
