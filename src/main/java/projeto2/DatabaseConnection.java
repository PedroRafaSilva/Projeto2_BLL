package projeto2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private static final String URL = "jdbc:postgresql://aavandredns.myqnapcloud.com:5432/Projeto1";
    private static final String USERNAME = "andreraspberrypi";
    private static final String PASSWORD = "PedroAndre123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    
}
