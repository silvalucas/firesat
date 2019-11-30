package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String BANCO = "firesat";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "org.gjt.mm.mysql.Driver";

    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + BANCO,
                    USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
