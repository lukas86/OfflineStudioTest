package repository;

import DB.DBProjectCommunication;
import DB.DBServerCommunication;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProjectRepository {

    public static void createNewProject(String projectName) {
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command("cmd.exe", "/c", "createProject.bat", projectName);
            builder.directory(new File("c:\\OfflineStudioTest"));
            Process p = builder.start();
            int exitValue = p.waitFor();
            if(exitValue > 0) {
                System.out.println("Error when executing script createProject.bat exit: " + exitValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] getListOfProjects() {
        String[] projectArray;
        try {
            if (DBServerCommunication.connect()) {
                Connection connection = DBServerCommunication.getConnection();

                PreparedStatement preparedStatement = connection
                        .prepareStatement("SELECT datname FROM pg_database WHERE datistemplate = false AND NOT datname = 'postgres'");

                ResultSet resultSet = preparedStatement.executeQuery();

                ArrayList<String> projectList = new ArrayList<>();
                while (resultSet.next()) {
                    projectList.add(resultSet.getString(1));
                }

                projectArray = projectList.toArray(new String[projectList.size()]);

                DBServerCommunication.closeResources(resultSet, preparedStatement, connection);

                return projectArray;
            } else {
                //TODO pobrisat?
                System.out.println("Can not connect to db");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void getProject(String projectName) {
        DBProjectCommunication.setCurrentDB(projectName);
        //TODO: v ločenem threadu?
//        //TODO: return Project
        PanelSettingRepository.getAll();
        PanelRepository.getAll();
        ModuleRepository.getAll();
        ZoneRepository.getAll();
    }

    public static void updateProject(String projectName) {
        //TODO: kako spremenit ime projekta če hranimo samo obstoječe ime ne prejšnjo?
        //DBProjectCommunication.setCurrentDB(projectName);

//        DialogManager.showWaitingToLoadAlert(projectName);
//        DialogManager.disposeOfWaitingDialog();
    }

    public static void deleteProject(String projectName) {
        //TODO: ali to sploh dovolimo?
    }

}
