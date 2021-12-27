package DB;

import java.sql.*;

public class DBCommunication {

//    private static final List<String> projectList = new ArrayList<>();
//
//    static {
//        projectList.add("test_project_#1");
//        projectList.add("test_project_#2");
//    }
//
//    public static String[] getListOfProjects() {
//        return projectList.toArray(new String[projectList.size()]);
//    }
//
//    public static void createNewProject(String projectName) {
//        projectList.add(projectName);
//    }

    private static final String CLASS_NAME = DBCommunication.class.getCanonicalName();

    private static final String SERVER_URL = "jdbc:postgresql://localhost:5433/";
    private static final String DRIVER = "org.postgresql.Driver";
//    private static final String USERNAME = "ACP";
//    private static final String PASSWORD = "acp3000";

    private static Connection DBConnection;

    public static boolean connect() {
        try {
            Class.forName(DRIVER);
//            Properties props = new Properties();
//            props.setProperty("user", USERNAME);
//            props.setProperty("password", PASSWORD);
            DBConnection = DriverManager.getConnection(SERVER_URL);
//            DBConnection = DriverManager.getConnection(URL, props);
//            LOGCommunication.addLogMessage("INFO", "DBCommunication/connect", "DB communication OK", CLASS_NAME);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
//            LOGCommunication.addLogMessage("SEVERE", "DBCommunication/connect", e, CLASS_NAME);
        }
        return false;
    }

    public static void closeResources(String method, PreparedStatement statement, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
//            LOGCommunication.addLogMessage("SEVERE", "DBCommunication/closeResources", e, CLASS_NAME);
        }

        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
//            LOGCommunication.addLogMessage("SEVERE", "DBCommunication/closeResources", e, CLASS_NAME);
        }
    }

    public static Connection getDBConnection() {
        try {
            if (DBConnection.isClosed() || DBConnection == null) {
                if (DBConnection != null) {
                    DBConnection.close();
                }
                connect();
            }
        } catch (Exception e) {
            e.printStackTrace();
//            LOGCommunication.addLogMessage("SEVERE", "DBCommunication/getDBConnection", e, CLASS_NAME);
        }
        return DBConnection;
    }


}
