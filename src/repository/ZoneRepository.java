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
    public static void getAll() {
        try {
            if (DBProjectCommunication.connectToDB()) {
                Connection connection = DBProjectCommunication.getDBConnection();

                String sql = "SELECT * FROM zones ORDER BY zone_number ASC";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ResultSet resultSet = preparedStatement.executeQuery();

                ArrayList<Zone> zones = new ArrayList<>();

                while (resultSet.next()) {
                    int zone_number = resultSet.getInt(1);
                    String description = resultSet.getString(2);
                    int panel_id = resultSet.getInt(3);

                    Zone zone = new Zone(zone_number, description, panel_id);

                    zones.add(zone);
                    System.out.println(zone);
                }

                DBProjectCommunication.closeDBResources(resultSet, preparedStatement, connection);
            } else {
                //TODO: odstranit?
                System.out.println("Can not connect to database");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void updateZones(List<Zone> zones) {
        try {
            if (DBProjectCommunication.connectToDB()) {
                Connection connection = DBProjectCommunication.getDBConnection();

                ArrayList<Panel> panelList = new ArrayList<>();

                String UPDATE_PANEL_SQL = "UPDATE zones SET zone_number = ?, description = ?, panel_id = ?";

                //TODO: raje upsert?
                String UPSERT_PANEL_SQL = "INSERT INTO zones(zone_number, description, panel_id) " +
                        "VALUES (?, ?, ?) " +
                        "ON CONFLICT (zone_number) " +
                        "DO UPDATE SET description = EXCLUDED.description, panel_id = EXCLUDED.panel_id";

                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PANEL_SQL);

                for(Zone zone : zones) {
                    if(zone != null) {
                        preparedStatement.setInt(1, zone.getZoneNumber());
                        preparedStatement.setString(2, zone.getDescription());
                        preparedStatement.setInt(3, zone.getPanelId());
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
                System.out.println("Can not connect to database");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    //TODO: kako pa DELETE? kako vedeti katere cone je potrebno pobrisat?
}
