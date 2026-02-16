//package OOP_CASE_BASED.CaseBased;

public class Pyramid {
    public static void main(String[] args) 
    {
        int i;
        int j;
        int k;
        for (i = 0; i < 8; i++) {
            // For space
            for (int space = 0; space < (7 - i); space++) {
                System.out.print("   ");
            }

            for (j = i; j >= 0; j--) {
                System.out.print((int) Math.pow(2, i - j) + "  ");
            }

            for (k = 1; k <= i; k++) {
                System.out.print((int) Math.pow(2, i - k) + "  ");
            }
            System.out.println();
        }
    }
}