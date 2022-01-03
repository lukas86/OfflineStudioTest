package repository;

import DB.DBProjectCommunication;
import model.Module;
import model.Panel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ModuleRepository {
    //TODO: ali se kar direktno nastavi podanemu panelu
    // ali raje vrače seznam modulov za podan panel_id?
    public static void getModulesOfPanelOfProject(String projectName, Panel panel) {
        try {
            if(panel == null) {
                return;
            }

            DBProjectCommunication.setCurrentDB(projectName);
            if (DBProjectCommunication.connectToDB()) {
                Connection connection = DBProjectCommunication.getDBConnection();

                String sql = "SELECT * FROM modules WHERE panel_id = ? ORDER BY module_id ASC";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, panel.getId());

                ResultSet resultSet = preparedStatement.executeQuery();

                ArrayList<Module> modules = new ArrayList<>();

                while (resultSet.next()) {
                    int localId = resultSet.getInt(1);
                    int globalId = resultSet.getInt(2);
                    String description = resultSet.getString(3);
                    int type = resultSet.getInt(4);
                    int panelId = resultSet.getInt(5);

                    Module module = new Module(localId, globalId, description, type, panelId);

                    modules.add(module);
                    System.out.println(module);
                }

                DBProjectCommunication.closeDBResources(resultSet, preparedStatement, connection);
            } else {
                System.out.println("Can not connect to " + projectName + " database");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void updateModulesOfPanelOfProject(String projectName, Panel panel) {
        try {
            DBProjectCommunication.setCurrentDB(projectName);
            if (DBProjectCommunication.connectToDB()) {
                Connection connection = DBProjectCommunication.getDBConnection();

                ArrayList<Module> modules = new ArrayList<>();

                String UPDATE_MODULE_SQL = "UPDATE modules SET local_id = ?, global_id = ?, module_description = ?," +
                        " type = ?, panel_id = ? FROM WHERE global_id = ?";

                //TODO: raje upsert?
                String UPSERT_MODULE_SQL = "INSERT INTO panels(local_id, global_id, module_description, type, panel_id) " +
                        "VALUES (?, ?, ?, ?) " +
                        "ON CONFLICT (global_id) DO UPDATE SET " +
                        "local_id = EXCLUDED.local_id, global_id = EXCLUDED.global_id, " +
                        "module_description = EXCLUDED.module_description, " +
                        "type = EXCLUDED.type, panel_id = EXCLUDED.panel_id";

                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MODULE_SQL);

                for(Module module : modules) {
                    if(module != null) {
//                        preparedStatement.setInt(1, module.getLocalId());
//                        preparedStatement.setInt(2, module.getGlobalId());
//                        preparedStatement.setString(3, module.getDescription());
//                        preparedStatement.setInt(4, module.getType());
//                        preparedStatement.setInt(5, module.getPanelId());

                        preparedStatement.setInt(1, module.getLocalId());
                        preparedStatement.setInt(2, module.getGlobalId());
                        preparedStatement.setString(3, module.getDescription());
                        preparedStatement.setInt(4, module.getType());
                        preparedStatement.setInt(5, module.getPanelId());
                        preparedStatement.setInt(6, module.getGlobalId());

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

    //TODO: kako pa DELETE? kako vedeti katere module je potrebno pobrisat?
    // (tukaj bo lahko gledali če ji tip modula NOT_PROGRAMED in jih v  tem primeru pobrisali v bazi?)

}
