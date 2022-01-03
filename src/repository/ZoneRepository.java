package repository;

import DB.DBProjectCommunication;
import model.Panel;
import model.Zone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ZoneRepository {
    //TODO: ZONES, kako ločit za kateri projekt gre, da ni potrebno vedno znova nastavljat
    private static void getZonesOfProject(String projectName) {
        try {
            DBProjectCommunication.setCurrentDB(projectName);
            if (DBProjectCommunication.connectToDB()) {
                Connection connection = DBProjectCommunication.getDBConnection();

                String sql = "SELECT * FROM zones ORDER BY zone_id ASC";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ResultSet resultSet = preparedStatement.executeQuery();

                ArrayList<Zone> zones = new ArrayList<>();

                System.out.println("project: " + projectName + " contains panels:");
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String description = resultSet.getString(2);


                    Zone zone = new Zone(id, description);

                    zones.add(zone);
                    System.out.println(zone);
                }

                DBProjectCommunication.closeDBResources(resultSet, preparedStatement, connection);
            } else {
                System.out.println("Can not connect to " + projectName + " database");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void updateZonesOfProject(String projectName, List<Zone> zones) {
        try {
            DBProjectCommunication.setCurrentDB(projectName);
            if (DBProjectCommunication.connectToDB()) {
                Connection connection = DBProjectCommunication.getDBConnection();

                ArrayList<Panel> panelList = new ArrayList<>();

                String UPDATE_PANEL_SQL = "UPDATE panels SET panel_description = ?, local_panel = ?, is_active = ? FROM WHERE panel_id = ?";

                //TODO: raje upsert?
                String UPSERT_PANEL_SQL = "INSERT INTO zones(zone_id, zone_description) " +
                        "VALUES (?, ?) " +
                        "ON CONFLICT (zone_id) " +
                        "DO UPDATE SET zone_description = EXCLUDED.zone_description";

                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PANEL_SQL);

                for(Zone zone : zones) {
                    if(zone != null) {
                        preparedStatement.setInt(1, zone.getId());
                        preparedStatement.setString(2, zone.getDescription());
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

    //TODO: kako pa DELETE? kako vedeti katere cone je potrebno pobrisat?
}
