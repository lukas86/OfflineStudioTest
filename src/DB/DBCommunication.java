package DB;

import java.sql.*;
import java.util.Properties;

public class DBCommunication {

    private static final String CLASS_NAME = DBCommunication.class.getCanonicalName();

    private static final String SERVER_URL = "jdbc:postgresql://localhost:5433/";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";

    private static Connection DBServerConnection;

    //TODO: connect to server
    public static boolean connectToServer() {
        try {
            Class.forName(DRIVER);
            Properties props = new Properties();
            props.setProperty("user", USERNAME);
            props.setProperty("password", PASSWORD);
            DBServerConnection = DriverManager.getConnection(SERVER_URL, props);
//            LOGCommunication.addLogMessage("INFO", "DBCommunication/connect", "DB communication OK", CLASS_NAME);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
//            LOGCommunication.addLogMessage("SEVERE", "DBCommunication/connect", e, CLASS_NAME);
        }
        return false;
    }

    public static void closeServerResources(ResultSet resultSet, PreparedStatement preparedStatement,  Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
//            LOGCommunication.addLogMessage("SEVERE", "DBCommunication/closeResources", e, CLASS_NAME);
        }

        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
//            LOGCommunication.addLogMessage("SEVERE", "DBCommunication/closeResources", e, CLASS_NAME);
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
//            LOGCommunication.addLogMessage("SEVERE", "DBCommunication/closeResources", e, CLASS_NAME);
        }
    }

    public static Connection getDBServerConnection() {
        try {
            if (DBServerConnection.isClosed() || DBServerConnection == null) {
                if (DBServerConnection != null) {
                    DBServerConnection.close();
                }
                connectToServer();
            }
        } catch (Exception e) {
            e.printStackTrace();
//            LOGCommunication.addLogMessage("SEVERE", "DBCommunication/getDBConnection", e, CLASS_NAME);
        }
        return DBServerConnection;
    }

    //TODO: get connection to specific database
    private static Connection DBConnection;

    public static boolean connectToDB(String projectName) {
        try {
            Class.forName(DRIVER);
            Properties props = new Properties();
            props.setProperty("user", USERNAME);
            props.setProperty("password", PASSWORD);
            String DB_URL = String.format("%s%s", SERVER_URL, projectName);
            DBConnection = DriverManager.getConnection(DB_URL, props);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Connection getDBConnection() {
        try {
            if (DBConnection.isClosed() || DBConnection == null) {
                if (DBConnection != null) {
                    DBConnection.close();
                }
                connectToServer();
            }
        } catch (Exception e) {
            e.printStackTrace();
//            LOGCommunication.addLogMessage("SEVERE", "DBCommunication/getDBConnection", e, CLASS_NAME);
        }
        return DBConnection;
    }

    public static void closeDBResources(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
//            LOGCommunication.addLogMessage("SEVERE", "DBCommunication/closeResources", e, CLASS_NAME);
        }

        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
//            LOGCommunication.addLogMessage("SEVERE", "DBCommunication/closeResources", e, CLASS_NAME);
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
//            LOGCommunication.addLogMessage("SEVERE", "DBCommunication/closeResources", e, CLASS_NAME);
        }
    }

}
