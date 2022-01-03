package repository;

import DB.DBServerCommunication;
import gui.dialog.DialogManager;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProjectRepository {

    public static void createNewProject(String projectName) {
        try {
            System.out.println("STARTED creating new project");

            ProcessBuilder builder = new ProcessBuilder();
            builder.command("cmd.exe", "/c", "createProject.bat", projectName);
            builder.directory(new File("c:\\OfflineStudioTest"));
            Process p = builder.start();

            int exitValue = p.waitFor();
            System.out.println("FINISHED creating new project; exitValue="+exitValue);
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
                        .prepareStatement("SELECT datname FROM pg_database WHERE datistemplate = false");

                ResultSet resultSet = preparedStatement.executeQuery();

                ArrayList<String> projectList = new ArrayList<>();
                while (resultSet.next()) {
                    projectList.add(resultSet.getString(1));
                }

                projectArray = projectList.toArray(new String[projectList.size()]);

                DBServerCommunication.closeResources(resultSet, preparedStatement, connection);

                return projectArray;
            } else {
                System.out.println("Can not connect to db");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void getProject(String projectName) {

        DialogManager.showWaitingToSaveAlert(projectName);

//        //TODO: return Project
//        SettingRepository.getSettingsOfProject(projectName);
//
//        PanelRepository.getPanelsOfProject(projectName);
//        //TODO: get zones
//        //TODO: get modules

        //TODO: temp
        try {
            Thread.sleep(5000);
        } catch(Exception ex) {

        }
        DialogManager.disposeOfWaitingDialog();
    }

    public static void updateProject(String projectName) {
        //TODO: kako spremenit ime projekta če hranimo samo obstoječe ime ne prejšnjo?
//        DialogManager.showWaitingToLoadAlert(projectName);
//        DialogManager.disposeOfWaitingDialog();
    }

    public static void deleteProject(String projectName) {
        //TODO: ali to sploh dovolimo?
    }

}
