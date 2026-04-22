package service;
import java.sql.*;
import java.util.*;
import repository.*;
import utilities.DBConnection;

public class StudentServices {

    static Scanner sc = new Scanner(System.in);

    // REGISTER COURSE METHOD
    public static void registerCourse(String email, String courseId,int semester) throws Exception 
    {
        if(CourseRepository.getEnrollmentCount(courseId) >= CourseRepository.getMaxSeats(courseId))
            throw new Exception("Course Full");

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO registrations(email,course_id,semester) VALUES(?,?,?)");
        ps.setString(1, email);
        ps.setString(2, courseId);
        ps.setInt(3,semester);
        ps.executeUpdate();
        PreparedStatement cred = con.prepareStatement("SELECT CREDITS FROM COURSES WHERE COURSE_ID = ?");
        cred.setString(1, courseId);
        ResultSet rs = cred.executeQuery();
        PreparedStatement pst = con.prepareStatement("UPDATE REGISTRATIONS r SET CREDITS=? WHERE r.COURSE_ID=?");
        rs.next();
        pst.setInt(1,rs.getInt("CREDITS"));
        pst.setString(2,courseId);
        pst.executeUpdate();

        System.out.println("Registered Successfully");
    }

    // DROP COURSE METHOD
    public static void dropCourse(String email, String courseId) throws Exception 
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM registrations WHERE email=? AND course_id=?");
        ps.setString(1, email);
        ps.setString(2, courseId);
        if(ps.executeUpdate()>0)
        {
            System.out.println("Course Dropped");
        }
        else
        {
            System.out.println("You were not enrolled in this course.");
        }
    }

    // VIEW SCHEDULE METHOD
    public static void viewSchedule() throws Exception 
    {
        System.out.println("Please enter your email."); 
        String mail = sc.nextLine();
        System.out.println("EMAIL = [" + mail + "]");
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM SCHEDULE s JOIN REGISTRATIONS r ON BINARY s.COURSE_ID = BINARY r.COURSE_ID WHERE r.EMAIL = ?");
        ps.setString(1, mail.trim());
        ResultSet rs = ps.executeQuery();

        System.out.println("COURSE_ID | TITLE | MONDAY | TUESDAY | WEDNESDAY | THURSDAY | FRIDAY");

        while (rs.next()) {
            System.out.println(
                rs.getString("COURSE_ID") + " | " +
                rs.getString("TITLE") + " | " +
                rs.getString("MONDAY") + " | " +
                rs.getString("TUESDAY") + " | " +
                rs.getString("WEDNESDAY") + " | " +
                rs.getString("THURSDAY") + " | " +
                rs.getString("FRIDAY")
        );
        }
    }

    // GPA CALCULATION
    public static void calculateGPA() throws Exception 
    {
        System.out.println("Please enter your email."); 
        String mail = sc.nextLine();
        System.out.println("Please enter the semester of the required GPA.");
        int sem=sc.nextInt();
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement("SELECT r.CREDITS, r.GRADE FROM registrations r JOIN courses c USING(COURSE_ID) WHERE r.EMAIL=? and c.SEMESTER=?");
        pst.setString(1,mail);
        pst.setInt(2,sem);
        ResultSet rs = pst.executeQuery();
        int totalCreds=0; 
        double totalPts=0;

        while(rs.next()){
            int c = rs.getInt("CREDITS");
            String g = rs.getString("GRADE");
            if(g==null){
                continue;
            }
            int gpa = g.equals("A")?10:g.equals("B")?8:g.equals("C")?6:4; //NESTED TERNARY OPERATOR
            totalCreds+=c;
            totalPts+=c*gpa;
        }

        if(totalPts==0) 
            System.out.println("No grades were assigned to any subject.");
        else
        {
            System.out.println("--GPA WAS CALCULATED TAKING ONLY SUBJECTS THAT WERE ASSIGNED A GRADE.--");
            System.out.println("GPA : "+(totalPts/totalCreds));
        }
    }

    //FEEDBACK COUNTER
    public static void giveFeedback() throws Exception
    {
        //sc.nextLine();
        System.out.println("Enter email.");
        String email = sc.nextLine();
        System.out.println("Enter course ID.");
        String coid = sc.nextLine();
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement("SELECT u.NAME, c.TITLE, c.PROFESSOR FROM USERS u JOIN REGISTRATIONS r ON u.EMAIL = r.EMAIL JOIN COURSES c ON r.COURSE_ID = c.COURSE_ID WHERE u.EMAIL = ? AND c.COURSE_ID = ?");
        pst.setString(1,email);
        pst.setString(2,coid);
        ResultSet rs = pst.executeQuery();

        String query = "INSERT INTO FEEDBACK (email, name, course_id, title, professor, rating, comment) VALUES (?, ?, ?, ?, ?, ?, ?)";

        System.out.println("Give your rating for this course out of 10.");
        int rating = sc.nextInt();

        sc.nextLine();
        System.out.println("Feedback for the professor?");
        String feedback=sc.nextLine();

        PreparedStatement ps = con.prepareStatement(query);
        rs.next();
        ps.setString(1, email);
        ps.setString(2, rs.getString("name"));
        ps.setString(3, coid);
        ps.setString(4, rs.getString("title"));
        ps.setString(5, rs.getString("professor"));
        ps.setInt(6, rating);
        ps.setString(7, feedback);

        int rows = ps.executeUpdate();

        if (rows > 0) 
        {
            System.out.println("Feedback submitted successfully!");
        } 
        else 
        {
            System.out.println("Failed to submit feedback.");
        }
    }
    public static void registerComplaint() throws Exception
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO COMPLAINTS(EMAIL,NAME,TYPE,COMPLAINT,STATUS) VALUES(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        System.out.println("Enter email.");
        String email = sc.nextLine();
        ps.setString(1,email);
        System.out.println("Enter name.");
        String name = sc.nextLine();
        ps.setString(2,name);
        String type[] = {"Course Related","Professor Related","Grading Error","Others"};
        System.out.println("Choose which type of complaint.");
        System.out.println(
        "1. Course Related\n"+
        "2. Professor Related\n"+
        "3. Grading Error\n"+
        "Press any other number for other type of complaint.");
        int choice = sc.nextInt();
        if(choice==1)
            ps.setString(3,type[0]);
        else if(choice==2)
           ps.setString(3,type[1]); 
        else if(choice==3)
            ps.setString(3,type[2]);
        else
        {
            ps.setString(3,"Others");
        }
        sc.nextLine();
        System.out.println("Enter your complaint within 200 characters.");
        String complaint = sc.nextLine();
        ps.setString(4,complaint);
        ps.setString(5,"Pending");
        int rows = ps.executeUpdate();

        if (rows > 0) 
        {
            ResultSet rs = ps.getGeneratedKeys(); //gives table of keys that were generated by sql
            if (rs.next()) 
            {
                int lastId = rs.getInt(1);
                System.out.println("Your complaint ID: " + lastId);
            }
        }
        System.out.println("Your complaint was registered. We will look into it and resolve it at the latest.");
    }
}

