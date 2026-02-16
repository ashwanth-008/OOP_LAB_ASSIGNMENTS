import java.util.Scanner;

public class PatternCount {

    public static int countPattern(int a, int b, String pattern) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (String.valueOf(i).contains(pattern)) count++;
        }
        return count;
    }

    // Demo
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter range a b:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Enter pattern:");
        String pattern = sc.next();
        sc.close();
        int result = countPattern(a, b, pattern);
        System.out.printf("The number of times '%s' occurred between %d and %d: %d\n", pattern, a, b, result);
    }
}

