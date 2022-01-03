package repository;

import DB.DBProjectCommunication;
import model.Panel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PanelRepository {

    //TODO: PANELS
    public static void getPanelsOfProject(String projectName) {
        try {
            DBProjectCommunication.setCurrentDB(projectName);
            if (DBProjectCommunication.connectToDB()) {
                Connection connection = DBProjectCommunication.getDBConnection();

                String sql = "SELECT * FROM panels ORDER BY panel_id ASC";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ResultSet resultSet = preparedStatement.executeQuery();

                ArrayList<Panel> panels = new ArrayList<>();

                System.out.println("project: " + projectName + " contains panels:");
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String description = resultSet.getString(2);
                    boolean isLocal = resultSet.getBoolean(3);
                    boolean isActive = resultSet.getBoolean(4);
                    int panelType = 0;

                    Panel panel = new Panel(id, description, isLocal, isActive, panelType);

                    panels.add(panel);
                    System.out.println(panel);
                }

                DBProjectCommunication.closeDBResources(resultSet, preparedStatement, connection);
            } else {
                System.out.println("Can not connect to " + projectName + " database");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void updatePanelsOfProject(String projectName) {
        try {
            DBProjectCommunication.setCurrentDB(projectName);
            if (DBProjectCommunication.connectToDB()) {
                Connection connection = DBProjectCommunication.getDBConnection();

                ArrayList<Panel> panels = new ArrayList<>();

                String UPDATE_PANEL_SQL = "UPDATE panels SET panel_description = ?, local_panel = ?, is_active = ? FROM WHERE panel_id = ?";

                //TODO: raje upsert?
                String UPSERT_PANEL_SQL = "INSERT INTO panels(panel_id, panel_description, local_panel, is_active) " +
                        "VALUES (?, ?, ?, ?) " +
                        "ON CONFLICT (panel_id) " +
                        "DO UPDATE SET panel_description = EXCLUDED.panel_description, local_panel = EXCLUDED.local_panel, is_active = EXCLUDED.is_active";

                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PANEL_SQL);

                for(Panel panel : panels) {
                    if(panel != null) {
//                        preparedStatement.setInt(1, panel.getId());
//                        preparedStatement.setString(2, panel.getDescription());
//                        preparedStatement.setBoolean(3, panel.isLocal());
//                        preparedStatement.setBoolean(4,panel.isActive());

                        preparedStatement.setString(1, panel.getDescription());
                        preparedStatement.setBoolean(2, panel.isLocal());
                        preparedStatement.setBoolean(3,panel.isActive());

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
                System.out.println("Can not connect to " + projectName + " database");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    //TODO: kako pa DELETE? kako vedeti katere panele je potrebno pobrisat?
    // (tukaj bo lahko gledali če ji tip panela NOT_PROGRAMED in jih v  tem primeru pobrisali v bazi?)

}
