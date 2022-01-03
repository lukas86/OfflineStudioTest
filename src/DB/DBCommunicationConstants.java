package DB;

import java.util.Properties;

public class DBCommunicationConstants {
    public static final String SERVER_URL = "jdbc:postgresql://localhost:5433/";
    public static final String DRIVER = "org.postgresql.Driver";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "admin";

    public static Properties getProperties() {
        Properties props = new Properties();
        props.setProperty("user", USERNAME);
        props.setProperty("password", PASSWORD);
        return props;
    }
}
