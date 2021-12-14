package project;

public class Project {
    private ProjectStateEnum state = ProjectStateEnum.NULL;;

    public ProjectStateEnum getState() {
        return state;
    }

    public void setState(ProjectStateEnum state) {
        this.state = state;
    }
}
