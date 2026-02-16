import java.util.Scanner;

public class PassValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter password to be checked:");
        String password = sc.nextLine();
        sc.close();

        int len = password.length();
        boolean isValid = true;

        // Rule 3: Length check
        if (len < 5 || len > 12) {
            isValid = false;
        }

        boolean hasLower = false;
        boolean hasDigit = false;

        // Rule 1 & 2: character validation
        for (int i = 0; i < len && isValid; i++) {
            char c = password.charAt(i);

            if (c >= 'a' && c <= 'z') {
                hasLower = true;
            } 
            else if (c >= '0' && c <= '9') {
                hasDigit = true;
            } 
            else {
                isValid = false; // uppercase or special character
            }
        }

        if (!hasLower || !hasDigit) {
            isValid = false;
        }

        // Rule 4: No immediate repeated patterns
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                isValid = false;
                break;
            }
        }


        System.out.println(password + ": " + (isValid ? "Valid" : "Invalid"));
    }
}



