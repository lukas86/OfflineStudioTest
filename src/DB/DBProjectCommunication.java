package DB;

import java.sql.*;

public class DBProjectCommunication {

    private static final String CLASS_NAME = DBProjectCommunication.class.getCanonicalName();

    private static Connection DBConnection;

    private static String currentDB;

    public static void setCurrentDB(String projectName) {
        currentDB = projectName;
    }

    public static void clearCurrentDB() {
        currentDB = null;
    }

    public static boolean connectToDB() {
        if (currentDB == null) {
            return false;
        }

        try {
            Class.forName(DBCommunicationConstants.DRIVER);
            String DB_URL = String.format("%s%s", DBCommunicationConstants.SERVER_URL, currentDB);
            DBConnection = DriverManager.getConnection(DB_URL, DBCommunicationConstants.getProperties());

            return true;
        } catch (Exception e) {
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
                connectToDB();
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
