package repository;

import DB.DBCommunication;
import model.Panel;

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
//                resultSet.close();
//                preparedStatement.close();
//                connection.close();

                return projectArray;
            } else {
                System.out.println("Can not connect to db");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void get(String projectName) {
        //TODO: return Project

        //TODO: get projectSettings
        //TODO: get panels
        //TODO: get zones
        //TODO: get modules
        try {
            if (DBCommunication.connectToDB(projectName)) {
                Connection connection = DBCommunication.getDBConnection();

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM panels ORDER BY panel_id ASC");

                ResultSet resultSet = preparedStatement.executeQuery();

                ArrayList<Panel> panelList = new ArrayList<>();

                System.out.println("project: " + projectName + " contains panels:");
                while (resultSet.next()) {
//                    projectList.add(resultSet.getString(1));
                    int id = resultSet.getInt(1);
                    String description = resultSet.getString(2);
                    boolean isLocal = resultSet.getBoolean(3);
                    boolean isActive = resultSet.getBoolean(4);

                    Panel panel = new Panel(id, description, isLocal, isActive);

                    panelList.add(panel);
                    System.out.println(panel);
                }

                DBCommunication.closeDBResources(resultSet, preparedStatement, connection);
            } else {
                System.out.println("Can not connect to " + projectName + " database");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void save() {
        //TODO: UPSERT / UPDATE
        //DBCommunication.update
    }

}
