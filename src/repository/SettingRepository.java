package repository;

import DB.DBCommunication;
import model.Setting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SettingRepository {

    public static void getSettingsOfProject(String projectName) {
        try {
            if (DBCommunication.connectToDB(projectName)) {
                Connection connection = DBCommunication.getDBConnection();

                String sql = "SELECT * FROM setting";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ResultSet resultSet = preparedStatement.executeQuery();

                //TODO: Settings object (key, value) or Map<Key, Value>?
                //TODO: default values?
                ArrayList<Setting> settings = new ArrayList<>();

                System.out.println("project: " + projectName + " contains panels:");
                while (resultSet.next()) {
                    String key = resultSet.getString(1);
                    String value = resultSet.getString(2);

                    Setting setting = new Setting(key, value);

                    settings.add(setting);
                    System.out.println(setting);
                }

                DBCommunication.closeDBResources(resultSet, preparedStatement, connection);
            } else {
                System.out.println("Can not connect to " + projectName + " database");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void updateSettingsOfProject(String projectName) {
        try {
            if (DBCommunication.connectToDB(projectName)) {
                Connection connection = DBCommunication.getDBConnection();

                ArrayList<Setting> settings = new ArrayList<>();

                String UPDATE_SETTING_SQL = "UPDATE settings SET value = ? FROM WHERE key = ?";

                //TODO: raje upsert?
                String UPSERT_SETTING_SQL = "INSERT INTO settings(key, value,) " +
                        "VALUES (?, ?) ON CONFLICT (key) DO UPDATE SET value = EXCLUDED.value";

                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SETTING_SQL);

                for(Setting setting : settings) {
                    if(setting != null) {
//                        preparedStatement.setString(1, setting.getKey());
//                        preparedStatement.setString(2, setting.getValue());

                        preparedStatement.setString(2, setting.getKey());
                        preparedStatement.setString(1, setting.getValue());

                        preparedStatement.executeQuery();
                    }
                }
//                //TODO: BATCH operations
//                statement.addBatch();
//                count++;
//                // execute every 100 rows or less
//                if (count % 100 == 0 || count == list.size()) {
//                    statement.executeBatch();
//                }

                DBCommunication.closeDBResources(null, preparedStatement, connection);
            } else {
                System.out.println("Can not connect to " + projectName + " database");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
