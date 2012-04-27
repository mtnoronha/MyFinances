package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

    private static String url = "jdbc:postgresql://localhost:5432/MyFinances";
    private static String user = "postgres";
    private static String pass = "tux@2pg";
    private static Connection conn;

    public static Connection open() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = null;
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        return conn;
    }
       
}
