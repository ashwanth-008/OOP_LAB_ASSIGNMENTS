import java.util.Scanner;
public class DateTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Date d = new Date(1, 20, 2025);
        d.displayDate();
        System.out.println("Input new date, month and year.");
        int newday=sc.nextInt();
        int newmonth=sc.nextInt();
        int newyear=sc.nextInt();
        d.setDay(newday);
        d.setMonth(newmonth);
        d.setYear(newyear);
        System.out.print("Updated date : ");
        d.displayDate();
    }
}

