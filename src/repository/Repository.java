package repository;

public class Repository {

    void createProject(String projectName) {
        ProjectRepository.createNewProject(projectName);

//        ProjectSettingsRepository.create();
//
//        PanelRepository.create();
//
//        ModuleRepository.create();
//
//        ZoneRepository.create();
    }

    String[] getListOfProjects() {
        return ProjectRepository.getListOfProjects();
    }
}
