package repository;
import java.sql.*;
import model.*;
import utilities.DBConnection;

public class UserRepository {

    // LOGIN METHOD
    public static DefaultUser login(String email, String password) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        if(!rs.next()){
            throw new Exception("Invalid Login");
        }

        String role = rs.getString("role");

        /*USING ROLE, WE RETURN THE ROLE OBJECT AS DONE BELOW */

        if(role.equalsIgnoreCase("student")) 
            return new Student();
        if(role.equalsIgnoreCase("professor")) 
            return new Professor();
        if(role.equalsIgnoreCase("admin")) 
            return new Admin();
        if(role.equalsIgnoreCase("TA")) 
            return new TeachingAssistant();

        return null; //null if none of the roles match
    }
}
