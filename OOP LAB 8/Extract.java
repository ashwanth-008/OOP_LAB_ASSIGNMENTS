import java.util.*;

public class Extract {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a line:");
        String str = sc.nextLine();

        int first = str.indexOf("the"); //

        if (first == -1) {
            System.out.println("'the' not found anywhere."); //indexof returns -1 if not found
            return;
        }

        // Find second occurrence after first occurence of 'the'
        int second = str.indexOf("the", first + 3);

        if (second == -1) {
            System.out.println("Second occurence of 'the' not found");
        } else {
            String result = str.substring(first + 3, second);

            System.out.println("First position: " + first);
            System.out.println("Second position: " + second);
            System.out.println("Extracted string: " + result);
        }
    }
}
