package repository;

import DB.DBProjectCommunication;
import model.Module;
import model.Panel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ModuleRepository {
    public static void getAll() {
        try {
            if (DBProjectCommunication.connectToDB()) {
                Connection connection = DBProjectCommunication.getDBConnection();

                String sql = "SELECT * FROM modules ORDER BY id_global ASC";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ResultSet resultSet = preparedStatement.executeQuery();

                ArrayList<Module> modules = new ArrayList<>();

                while (resultSet.next()) {
                    int idLocal = resultSet.getInt(1);
                    int idGlobal = resultSet.getInt(2);
                    int panelId = resultSet.getInt(3);
                    int moduleTypeId = resultSet.getInt(4);
                    boolean isActive = resultSet.getBoolean(5);
                    String moduleDescription = resultSet.getString(6);

                    Module module = new Module(idLocal, idGlobal, panelId, moduleTypeId, isActive, moduleDescription);

                    modules.add(module);
                    System.out.println(module);
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
    //TODO: ali se kar direktno nastavi podanemu panelu
    // ali raje vrače seznam modulov za podan panel_id?
    public static void getModulesOfPanel(Panel panel) {
        try {
            if(panel == null) {
                return;
            }

            if (DBProjectCommunication.connectToDB()) {
                Connection connection = DBProjectCommunication.getDBConnection();

                String sql = "SELECT * FROM modules WHERE panel_id = ? ORDER BY module_id ASC";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, panel.getId());

                ResultSet resultSet = preparedStatement.executeQuery();

                ArrayList<Module> modules = new ArrayList<>();

                while (resultSet.next()) {
                    int idLocal = resultSet.getInt(1);
                    int idGlobal = resultSet.getInt(2);
                    int panelId = resultSet.getInt(3);
                    int moduleTypeId = resultSet.getInt(4);
                    boolean isActive = resultSet.getBoolean(5);
                    String moduleDescription = resultSet.getString(6);

                    Module module = new Module(idLocal, idGlobal, panelId, moduleTypeId, isActive, moduleDescription);

                    modules.add(module);
                    System.out.println(module);
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

    public static void updateModules() {
        try {
            if (DBProjectCommunication.connectToDB()) {
                Connection connection = DBProjectCommunication.getDBConnection();

                ArrayList<Module> modules = new ArrayList<>();

                String UPDATE_MODULE_SQL = "UPDATE modules SET id_global = ?, id_local = ?, panel_id = ?, type = ?, module_description = ?" +
                        "  FROM WHERE global_id = ?";

//                //TODO: raje upsert?
//                String UPSERT_MODULE_SQL = "INSERT INTO panels(local_id, global_id, module_description, type, panel_id) " +
//                        "VALUES (?, ?, ?, ?) " +
//                        "ON CONFLICT (global_id) DO UPDATE SET " +
//                        "local_id = EXCLUDED.local_id, global_id = EXCLUDED.global_id, " +
//                        "module_description = EXCLUDED.module_description, " +
//                        "type = EXCLUDED.type, panel_id = EXCLUDED.panel_id";

                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MODULE_SQL);

                for(Module module : modules) {
                    if(module != null) {
//                        preparedStatement.setInt(1, module.getLocalId());
//                        preparedStatement.setInt(2, module.getGlobalId());
//                        preparedStatement.setString(3, module.getDescription());
//                        preparedStatement.setInt(4, module.getType());
//                        preparedStatement.setInt(5, module.getPanelId());

                        preparedStatement.setInt(1, module.getIdGlobal());
                        preparedStatement.setInt(2, module.getIdLocal());
                        preparedStatement.setInt(3, module.getPanelId());
                        preparedStatement.setInt(4, module.getModuleTypeId());
                        preparedStatement.setBoolean(5, module.isActive());
                        preparedStatement.setString(6, module.getModuleDescription());

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

    //TODO: kako pa DELETE? kako vedeti katere module je potrebno pobrisat?
    // (tukaj bo lahko gledali če ji tip modula NOT_PROGRAMED in jih v  tem primeru pobrisali v bazi?)

}
