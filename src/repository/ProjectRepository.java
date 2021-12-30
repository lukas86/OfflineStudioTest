package repository;

import DB.DBCommunication;
import model.Panel;
import model.Module;
import model.Setting;
import model.Zone;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
            if (DBCommunication.connectToServer()) {
                Connection connection = DBCommunication.getDBServerConnection();

                PreparedStatement preparedStatement = connection
                        .prepareStatement("SELECT datname FROM pg_database WHERE datistemplate = false");

                ResultSet resultSet = preparedStatement.executeQuery();

                ArrayList<String> projectList = new ArrayList<>();
                while (resultSet.next()) {
                    projectList.add(resultSet.getString(1));
                }

                projectArray = projectList.toArray(new String[projectList.size()]);

                DBCommunication.closeServerResources(resultSet, preparedStatement, connection);

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
        //TODO: return Project
        //TODO: get projectSettings
        //TODO: get zones
        //TODO: get modules
        //TODO: get panels
        PanelRepository.getPanelsOfProject(projectName);
    }

    public static void updateProject(String projectName) {
        //TODO: kako spremenit ime projekta če hranimo samo obstoječe ime ne prejšnjo?
    }

    public static void deleteProject(String projectName) {
        //TODO: ali to sploh dovolimo?
    }




}
