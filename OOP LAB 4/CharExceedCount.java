import java.util.Scanner;
public class CharExceedCount {

    public static void printCharsExceeding(String str, int n) {
        int[] freq = new int[256];  // Frequency array for all ASCII characters (all 256 characters)
        // Count occurrences of each character
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;      //str.charAt(i) is automatically converted to int (gives ASCII code)
        }
        // Print characters whose frequency exceeds n
        System.out.print("Characters appearing more than " + n + " times: ");
        for (int i = 0; i < 256; i++) {
            if (freq[i] > n) {
                System.out.print((char) i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();
        System.out.println("Enter the threshold number n:");
        int n = sc.nextInt();
        sc.close();

        printCharsExceeding(input, n);
    }
}

