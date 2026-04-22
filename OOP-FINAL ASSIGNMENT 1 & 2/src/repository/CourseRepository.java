package repository;
import java.sql.*;
import java.util.*;
import utilities.DBConnection;

public class CourseRepository 
{
    static Scanner sc = new Scanner(System.in);
    // VIEW COURSES METHOD
    public static void viewCourses()
    {
        try(Connection con = DBConnection.getConnection())
        {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM courses");
            while(rs.next())
            {
                System.out.println(rs.getString("COURSE_ID")+" \n" + 
                rs.getString("TITLE")+"\n" + 
                rs.getString("PROFESSOR")+" \n" +
                "Credits:" + rs.getInt("CREDITS")+"\n"+
                "Semester:"+rs.getInt("SEMESTER")+"\n"+
            "Days per week:"+rs.getInt("daysperweek")+"\n"+
            "Prequisites:"+rs.getString("PREREQ")+" \n" +
            "Maximum seats:"+rs.getInt("MAX_SEATS")+"\n");
            }
        }
        catch(Exception e)
        { 
            e.printStackTrace(); 
        }
    }

    public static void deleteChapter(){
        try
        {
            sc.nextLine();
            Connection con = DBConnection.getConnection();
            System.out.println("Enter course ID.");
            String tablename=sc.nextLine();
            String query="DELETE FROM "+tablename+" WHERE CHAPTERS=?";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("Enter name of chapter to be deleted.");
            String chapter=sc.nextLine();
            ps.setString(1,chapter);
            ps.executeUpdate();
            System.out.println("Chapter was deleted from course "+tablename+".");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void addChapter()
    {
        try
        {
            sc.nextLine();
            Connection con = DBConnection.getConnection();
            System.out.println("Enter course ID.");
            String tablename=sc.nextLine();
            String query="INSERT INTO "+tablename+" VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("Enter name of chapter to be added.");
            String chapter=sc.nextLine();
            System.out.println("Enter number of hours required for chapter completion.");
            int hrs=sc.nextInt();
            ps.setString(1,chapter);
            ps.setInt(2,hrs);
            ps.executeUpdate();
            System.out.println("Chapter was added to course "+tablename+".");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static int getEnrollmentCount(String courseId) throws Exception
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM registrations WHERE course_id=?");
        ps.setString(1, courseId);
        ResultSet rs = ps.executeQuery(); 
        rs.next();
        return rs.getInt("COUNT(*)"); //OR rs.getInt(1) returns data of first column of the current row of rs
    }

    public static int getMaxSeats(String courseId) throws Exception{
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT max_seats FROM courses WHERE course_id=?");
        ps.setString(1, courseId);
        ResultSet rs = ps.executeQuery(); 
        rs.next();
        return rs.getInt(1);
    }
}