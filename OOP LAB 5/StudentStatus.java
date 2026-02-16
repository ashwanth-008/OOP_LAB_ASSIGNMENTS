import java.util.Scanner;
public class StudentStatus {
    String inputName(String name) {
        return name;
    }
    String average(int m1, int m2, int m3) {
        double avg = (m1 + m2 + m3) / 3.0;

        if (avg > 50)
            return "Pass";
        else
            return "Fail";
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentStatus stu = new StudentStatus();   
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter 3 Marks:");
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        System.out.println("Name: " + stu.inputName(name));   
        System.out.println("Result: " + stu.average(m1, m2, m3));

        sc.close();
    }
}

