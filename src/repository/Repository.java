package repository;

public class Repository {

    void createProject(String projectName) {
        ProjectRepository.createNewProject(projectName);

        //TODO: save -> delete project -> create new -> insert values
    }

    String[] getListOfProjects() {
        return ProjectRepository.getListOfProjects();
    }
}
