import java.util.Scanner;

public class PerfectString {

    public static boolean isPerfect(String str) {
        boolean[] seen = new boolean[256]; // Supports all ASCII characters
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (seen[c]) {  // Already seen this character
                return false;
            }
            seen[c] = true; // Mark character as seen
        }

        return true; // All characters are unique
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();
        sc.close();

        if (isPerfect(input)) {
            System.out.println("The string is perfect.");
        } else {
            System.out.println("The string is NOT perfect.");
        }
    }
}
