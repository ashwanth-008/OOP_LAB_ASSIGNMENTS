package utilities;
import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/oop_university";
    private static final String USER = "root";
    private static final String PASS = "admin";

    public static Connection getConnection() throws SQLException 
    {
        return DriverManager.getConnection(URL, USER, PASS); //no need to load Class.forName("com.mysql.jdbc.Driver")
    }
}
