package repository;

public class ProjectRepository {
    public static void createNewProject(String projectName) {
        //TODO: create database
        //DBCommunication
    }

    public static String[] getListOfProjects() {
        //TODO: load
        //TODO: SELECT * FROM
        return new String[]{"test_project_#1", "test_project_#2", "test_project_#3"};
        //DBCommunication.
    }

    public static void save() {
        //TODO: UPSERT / UPDATE
        //DBCommunication.update
    }

}
