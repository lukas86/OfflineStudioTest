package repository;

import DB.DBProjectCommunication;
import model.PanelSetting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PanelSettingRepository {

    public static void getAll() {
        try {
            //TODO:?
//            DBProjectCommunication.setCurrentDB(projectName);

            if (DBProjectCommunication.connectToDB()) {
                Connection connection = DBProjectCommunication.getDBConnection();

                //TODO: to je bolj preimenovat v system_settings?
                String sql = "SELECT * FROM panel_settings";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ResultSet resultSet = preparedStatement.executeQuery();

                ArrayList<PanelSetting> panelSettings = new ArrayList<>();

                while (resultSet.next()) {
                    int panel_id = resultSet.getInt(1);
                    String key = resultSet.getString(2);
                    String value = resultSet.getString(3);

                    PanelSetting panelSetting = new PanelSetting(panel_id, key, value);

                    panelSettings.add(panelSetting);
                    System.out.println(panelSetting);
                }

                DBProjectCommunication.closeDBResources(resultSet, preparedStatement, connection);
            } else {
                //TODO pobrisat?
                System.out.println("Can not connect to database");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void updateSettingsOfProject() {
        try {
            //TODO:?
//            DBProjectCommunication.setCurrentDB(projectName);

            if (DBProjectCommunication.connectToDB()) {
                Connection connection = DBProjectCommunication.getDBConnection();

                ArrayList<PanelSetting> panelSettings = new ArrayList<>();

                String UPDATE_SETTING_SQL = "UPDATE settings SET value = ? FROM WHERE key = ? AND panel_id = ?";

                //TODO: raje upsert?
                String UPSERT_SETTING_SQL = "INSERT INTO settings(key, value, panel_id) " +
                        "VALUES (?, ?, ?) ON CONFLICT (panel_id, key) DO UPDATE SET value = EXCLUDED.value";

                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SETTING_SQL);

                for(PanelSetting panelSetting : panelSettings) {
                    if(panelSetting != null) {
                        preparedStatement.setString(1, panelSetting.getValue());
                        preparedStatement.setString(2, panelSetting.getKey());
                        preparedStatement.setInt(3, panelSetting.getPanelId());

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

                DBProjectCommunication.closeDBResources(null, preparedStatement, connection);
            } else {
                //TODO pobrisat?
                System.out.println("Can not connect to database");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
