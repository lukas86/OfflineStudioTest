package DB;

import java.sql.*;

public class DBServerCommunication {
    private static final String CLASS_NAME = DBServerCommunication.class.getCanonicalName();

    private static Connection DBServerConnection;

    //TODO: connect to server
    public static boolean connect() {
        try {
            Class.forName(DBCommunicationConstants.DRIVER);
            DBServerConnection = DriverManager.getConnection(DBCommunicationConstants.SERVER_URL,
                    DBCommunicationConstants.getProperties());
//            LOGCommunication.addLogMessage("INFO", "DBCommunication/connect", "DB communication OK", CLASS_NAME);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
//            LOGCommunication.addLogMessage("SEVERE", "DBCommunication/connect", e, CLASS_NAME);
        }
        return false;
    }

    public static Connection getConnection() {
        try {
            if (DBServerConnection.isClosed() || DBServerConnection == null) {
                if (DBServerConnection != null) {
                    DBServerConnection.close();
                }
                connect();
            }
        } catch (Exception e) {
            e.printStackTrace();
//            LOGCommunication.addLogMessage("SEVERE", "DBCommunication/getDBConnection", e, CLASS_NAME);
        }
        return DBServerConnection;
    }

    public static void closeResources(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
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
