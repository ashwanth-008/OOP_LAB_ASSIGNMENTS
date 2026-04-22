package main;

import java.sql.*;
import java.util.*;
import model.*;
import repository.*;
import service.*;
import utilities.DBConnection;

public class UniMain 
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) 
    {
        while(true)
        {
            System.out.println("1.Login\n2.Exit");
            int ch = sc.nextInt();

            if(ch == 1) 
                Mainlogin(); 
            else 
                break;
        }
    }

    // ===================== LOGIN METHOD  =====================
    static void Mainlogin()
    {
        System.out.println("Welcome! Please enter your email and password\n"+
        "so that we can get you started with your desired function.");
        try
        {
            sc.nextLine();
            System.out.print("Email: "); 
            String e = sc.nextLine();

            System.out.print("Password: "); 
            String p = sc.nextLine();

            DefaultUser u = UserRepository.login(e, p);
            if(u instanceof TeachingAssistant) {
                System.out.println("Teaching assistant login detected.");
                taMenu();
            }
            else if(u instanceof Student) {
                System.out.println("Student login detected.");
                studentMenu();
            }
            else if(u instanceof Professor) {
                System.out.println("Professor login detected.");
                professorMenu();
            }
            else if(u instanceof Admin) {
                System.out.println("Admin login detected.");
                adminMenu();
            }
        }
        catch(Exception ex)
        { 
            System.out.println(ex.getMessage()); 
        }
    }

    // ===================== STUDENT MENU =====================
    static void studentMenu()
    {
        while(true)
        {
            System.out.println("What would you like to do?");
            System.out.println(
                "1.View Courses\n" +
                "2.Register\n" +
                "3.Drop\n" +
                "4.Schedule\n" +
                "5.View Calculated GPA\n" +
                "6.Course Feedback\n"+
                "7.Complaint Service\n"+
                "8.Logout");

            int ch = sc.nextInt();

            try
            {
                if(ch == 1)
                {
                    System.out.println("You've opted to view all courses.");
                    CourseRepository.viewCourses();
                    sc.nextLine();
                }
                else if(ch == 2)
                { 
                    sc.nextLine();
                    System.out.println("You've opted to register for a course!");
                    System.out.println("Please enter your email."); 
                    String mail = sc.nextLine();

                    System.out.println("Enter course ID of the course you want to register for."); 
                    String cid = sc.next(); 
                    System.out.println("Enter course semester.");
                    int sem=sc.nextInt();

                    sc.nextLine();

                    StudentServices.registerCourse(mail,cid,sem); 
                }
                else if(ch == 3)
                { 
                    sc.nextLine();
                    System.out.println("You've opted to drop a course.");
                    System.out.println("Please enter your email."); 
                    String mail = sc.nextLine();

                    System.out.println("Please enter course ID of the course to be dropped."); 
                    String cid = sc.next();

                    StudentServices.dropCourse(mail, cid); 
                }
                else if(ch == 4)
                {
                    System.out.println("You've opted to view your schedule.");

                    sc.nextLine();

                    StudentServices.viewSchedule();
                }
                else if(ch == 5)
                {
                    System.out.println("You've opted to view your calculated GPA.");

                    sc.nextLine();

                    StudentServices.calculateGPA();
                }
                else if(ch == 6)
                { 
                    System.out.println("You've opted for the feedback service.");
                    StudentServices.giveFeedback();
                    sc.nextLine();
                }
                else if(ch==7){
                    System.out.println("You've opted for the complaint service.");
                    StudentServices.registerComplaint();
                    sc.nextLine();
                }
                else 
                    break;
            }
            catch(Exception e)
            { 
                System.out.println(e.getMessage()); 
            }
        }
    }

    // ===================== PROFESSOR MENU =====================
    static void professorMenu() throws Exception
    {
        System.out.println("Please choose your desired function.");
        while(true)
        {
            System.out.println(
                "1.View Courses\n" +
                "2.Update Course\n" +
                "3.View Enrolled Students\n" +
                "4.Assign Grade\n"+
                "5.View Feedback\n" +
                "6.Logout"
            );

            int ch = sc.nextInt();

            if(ch == 1) 
            {
                System.out.println("You've opted to view all courses.");
                CourseRepository.viewCourses();
            }
            else if(ch == 2)
            {
                System.out.println("You've opted to update a course.");
                System.out.println("Press 1 to add a chapter to the course.");
                System.out.println("Press 2 to delete a chapter from the course.");
                int choice = sc.nextInt();
                if(choice==1)
                {
                    CourseRepository.addChapter();
                }
                else if(choice==2)
                {
                    CourseRepository.deleteChapter();
                }
                else
                {
                    System.out.println("Invalid choice.");
                }
            }
            else if(ch == 3)
            {
                System.out.println("You've opted to view all enrolled students in a course.");
                try(Connection con = DBConnection.getConnection())
                {
                    sc.nextLine();
                    PreparedStatement pst = con.prepareStatement("SELECT * FROM registrations where COURSE_ID=?");
                    System.out.println("Enter course ID.");
                    String cid = sc.nextLine();
                    pst.setString(1,cid);
                    ResultSet rs = pst.executeQuery();

                    while(rs.next())
                    {
                        System.out.println("Student Email : "+rs.getString("EMAIL") + "\n" + 
                        "Semester : "+rs.getInt("SEMESTER")+"\n"+
                        "Grade : "+rs.getString("GRADE")+"\n");
                    }
                }
                catch(Exception e)
                { 
                    e.printStackTrace(); 
                }
            }
            else if(ch==4)
            {
                System.out.println("You've opted to assign grades to a student/TA.");
                sc.nextLine();
                Connection con = DBConnection.getConnection();
                System.out.println("Enter course ID.");
                String cid = sc.nextLine();
                System.out.println("Enter student email.");
                String email = sc.nextLine();
                PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE email=?");
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                String role = rs.getString("role");
                if(role.equalsIgnoreCase("Professor")||role.equalsIgnoreCase("Admin"))
                {
                    System.out.println("WARNING : You can only assign grades to students and TAs.");
                }
                else
                {
                    System.out.println("Enter student's grade for this course.");
                    String grade = sc.nextLine();
                    PreparedStatement ps = con.prepareStatement("UPDATE REGISTRATIONS SET GRADE=? WHERE EMAIL=? AND COURSE_ID=?");
                    ps.setString(1,grade);
                    ps.setString(2,email);
                    ps.setString(3,cid);
                    ps.executeUpdate();
                    System.out.println("Grade assigned sucessfully.");
                }
            }
            else if(ch == 5)
            {
                System.out.println("You've opted to view the feedback counter.");
                try
                {
                    Connection con = DBConnection.getConnection();

                    PreparedStatement ps = con.prepareStatement(
                        "SELECT u.NAME, f.RATING, f.COMMENT, f.COURSE_ID " +
                        "FROM feedback f " +
                        "JOIN users u ON f.EMAIL = u.EMAIL " +
                        "WHERE f.COURSE_ID = ?");

                    System.out.println("Enter course ID for which feedback is to be viewed.");
                    String cid = sc.next();
                    ps.setString(1, cid);

                    ResultSet rs = ps.executeQuery();

                    boolean found = false;

                    while(rs.next()) 
                    {
                        found = true;
                        System.out.println("Course: " + rs.getString("COURSE_ID"));
                        System.out.println("Student: " + rs.getString("NAME"));
                        System.out.println("Rating (out of 10): " + rs.getInt("RATING"));
                        System.out.println("Comment: " + rs.getString("COMMENT"));
                        System.out.println("-------------------------");
                    }

                    if(!found)
                    {
                        System.out.println("No feedback found for this course.");
                    }

                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else 
                break;
        }
    }

    // ===================== ADMIN MENU =====================
    static void adminMenu()
    {
        System.out.println("Choose your desired function carefully.");
        while(true)
        {
            System.out.println(
                "1.Add Course\n" +
                "2.Delete Course\n" +
                "3.View Complaints\n" +
                "4.Resolve Complaint\n" +
                "5.Add User\n" +
                "6.Modify Course\n"+
                "7.Assign Course to Professor\n"+
                "8.Logout"
            );

            int ch = sc.nextInt();

            try
            {
                if(ch == 1)
                {
                    System.out.println("You've opted to add a course. Enter the required details.");
                    sc.nextLine();

                    System.out.print("Course ID:");
                    String id = sc.nextLine();

                    System.out.print("Title:");
                    String t = sc.nextLine();

                    System.out.print("Professor:");
                    String prof = sc.nextLine();

                    System.out.print("Semester:");
                    int sem = sc.nextInt();

                    System.out.print("Credits:");
                    int c = sc.nextInt();

                    System.out.print("Days per week:");
                    int dpw = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Prerequisites:");
                    String pre = sc.nextLine();

                    System.out.print("Max Seats:");
                    int m = sc.nextInt();

                    Connection con = DBConnection.getConnection();

                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO courses VALUES(?,?,?,?,?,?,?,?)"
                    );

                    ps.setString(1, id); 
                    ps.setString(2, t); 
                    ps.setString(3, prof); 
                    ps.setInt(4, sem);
                    ps.setInt(5, dpw);
                    ps.setString(6, pre); 
                    ps.setInt(7, c);
                    ps.setInt(8, m);


                    ps.executeUpdate();

                    System.out.println("Course Added");
                    String create = "CREATE TABLE " + id + " (CHAPTERS VARCHAR(50), HOURS INT)";
                    try (PreparedStatement pstmt = con.prepareStatement(create)) 
                    {
                        pstmt.executeUpdate();
                    }
                }
                else if(ch == 2)
                {
                    System.out.println("You've opted to delete a course. Enter the required details.");
                    System.out.print("Course ID:");
                    String cid = sc.next();

                    Connection con = DBConnection.getConnection();

                    PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM courses WHERE course_id=?"
                    );

                    ps.setString(1, cid);
                    ps.executeUpdate();

                    PreparedStatement pst = con.prepareStatement("DROP TABLE "+cid+";");
                    pst.executeUpdate();

                    System.out.println("Course Deleted");
                }
                else if(ch == 3)
                {
                    System.out.println("You've opted to view all complaints.");
                    Connection con = DBConnection.getConnection();
                    ResultSet rs = con.createStatement().executeQuery("SELECT * FROM COMPLAINTS");
                    while(rs.next()){
                        System.out.println("Name : "+rs.getString("NAME")+"\n"+
                        "Email : "+rs.getString("EMAIL")+"\n"+
                        "Complaint ID : "+rs.getString("COMPLAINT_ID")+"\n"+
                        "Type of complaint : "+rs.getString("TYPE")+"\n"+
                        "Complaint : "+rs.getString("COMPLAINT")+"\n"+
                        "Status : "+rs.getString("STATUS")+"\n");
                    }
                }
                else if(ch == 4)
                {
                    System.out.println("You've opted to resolve a complaint.");
                    System.out.print("Enter the complaint ID:"); 
                    int cid = sc.nextInt();

                    Connection con = DBConnection.getConnection();

                    PreparedStatement ps = con.prepareStatement(
                        "UPDATE COMPLAINTS SET status='Resolved' WHERE COMPLAINT_ID=?"
                    );

                    ps.setInt(1, cid);
                    ps.executeUpdate();

                    System.out.println("Complaint Resolved");
                }
                else if(ch == 5)
                {
                    sc.nextLine();
                    System.out.println("You've opted to add a user to the database.");

                    System.out.println("Enter user email ID."); 
                    String mail = sc.nextLine();

                    System.out.println("Enter user password."); 
                    String pas = sc.nextLine();

                    System.out.println("Enter user name."); 
                    String name = sc.nextLine();

                    System.out.println("Enter user role."); 
                    String role = sc.nextLine();

                    Connection con = DBConnection.getConnection();

                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO USERS VALUES(?,?,?,?)"
                    );

                    ps.setString(1, name);
                    ps.setString(2, mail);
                    ps.setString(3, pas);
                    ps.setString(4, role);

                    ps.executeUpdate();

                    System.out.println("User was added to the database successfully.");
                }
                else if(ch==6){
                    System.out.println("You've opted to modify a course.");
                    System.out.println("Press 1 to add a chapter to the course.");
                    System.out.println("Press 2 to delete a chapter from the course.");
                    int choice = sc.nextInt();
                    if(choice==1)
                    {
                        CourseRepository.addChapter();
                    }
                    else if(choice==2)
                    {
                        CourseRepository.deleteChapter();
                    }
                    else
                    {
                        System.out.println("Invalid choice.");
                    }
                }
                else if(ch==7)
                {
                    System.out.println("You've opted to assign a course to a professor.");
                    sc.nextLine();
                    Connection con = DBConnection.getConnection();
                    System.out.println("Enter course ID.");
                    String cid = sc.nextLine();
                    System.out.println("Enter professor email.");
                    String email = sc.nextLine();
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS WHERE EMAIL=?");
                    ps.setString(1,email);
                    ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                        PreparedStatement pst = con.prepareStatement("UPDATE COURSES SET PROFESSOR=? WHERE COURSE_ID=?");
                        pst.setString(1,rs.getString("NAME"));
                        pst.setString(2,cid);
                        int rows = pst.executeUpdate();
                        if(rows>0){
                            System.out.println("Professor was assigned to the course.");
                        }
                        else{
                            System.out.println("An unknown error has occured. Please check input values for human error.");
                        }
                    }
                    else{
                        System.out.println("Professor was not found in database. Add professor to the database first.");
                    }
                }
                else 
                    break;
            }
            catch(Exception e)
            { 
                System.out.println(e.getMessage()); 
            }
        }
    }

    // ===================== TA MENU =====================
    static void taMenu() throws Exception
    {
        while(true)
        {
            System.out.println(
                "1.View Courses\n" +
                "2.Register\n" +
                "3.Drop\n" +
                "4.Schedule\n" +
                "5.GPA\n" +
                "6.Course Feedback\n"+
                "7.Complaint Service\n"+
                "8.Assign Grade\n" +
                "9.Logout"
            );

            int ch = sc.nextInt();

            if(ch == 1)
            {
                CourseRepository.viewCourses();
            }
            else if(ch == 2)
            { 
                sc.nextLine();
                System.out.println("You've opted to register for a course!");
                System.out.println("Please enter your email."); 
                String mail = sc.nextLine();

                System.out.println("Enter course ID of the course you want to register for."); 
                String cid = sc.next(); 
                System.out.println("Enter course semester.");
                int sem=sc.nextInt();

                sc.nextLine();

                StudentServices.registerCourse(mail,cid,sem); 
            }
            else if(ch == 3)
            { 
                sc.nextLine();
                System.out.println("You've opted to drop a course.");
                System.out.println("Please enter your email."); 
                String mail = sc.nextLine();

                System.out.println("Please enter course ID of the course to be dropped."); 
                String cid = sc.next();

                StudentServices.dropCourse(mail, cid); 
            }
            else if(ch == 4)
            {
                System.out.println("You've opted to view your schedule.");

                sc.nextLine();

                StudentServices.viewSchedule();
            }
            else if(ch == 5)
            {
                System.out.println("You've opted to view your calculated GPA.");

                sc.nextLine();

                StudentServices.calculateGPA();
            }
            else if(ch == 6)
            { 
                System.out.println("You've opted for the feedback service.");
                StudentServices.giveFeedback();
                sc.nextLine();
            }
            else if(ch==7){
                System.out.println("You've opted for the complaint service.");
                StudentServices.registerComplaint();
                sc.nextLine();
            }
            else if(ch == 8) 
            {
                sc.nextLine();
                Connection con = DBConnection.getConnection();
                System.out.println("Enter course ID.");
                String cid = sc.nextLine();
                System.out.println("Enter student email.");
                String email = sc.nextLine();
                PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE email=?");
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                String role = rs.getString("role");
                if(role.equalsIgnoreCase("Student"))
                {
                    System.out.println("Enter student's grade for this course.");
                    String grade = sc.nextLine();
                    PreparedStatement ps = con.prepareStatement("UPDATE REGISTRATIONS SET GRADE=? WHERE EMAIL=? AND COURSE_ID=?");
                    ps.setString(1,grade);
                    ps.setString(2,email);
                    ps.setString(3,cid);
                    ps.executeUpdate();
                    System.out.println("Grade assigned sucessfully.");
                }
                else
                {
                    System.out.println("WARNING : You can only assign grades to students.");
                }
            }
            else 
                break;
        }
    }
}

