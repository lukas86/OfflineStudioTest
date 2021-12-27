package repository;

public class Repository {
    void createProject() {
        ProjectRepository.create();

        ProjectSettingsRepository.create();

        PanelRepository.create();

        ModuleRepository.create();

        ZoneRepository.create();
    }
}
