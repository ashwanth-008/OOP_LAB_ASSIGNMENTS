import java.util.*;

class ConvertThread extends Thread {
    String postfix;
    String result;

    ConvertThread(String postfix) {
        this.postfix = postfix;
    }

    public void run() {
        Stack<String> stack = new Stack<>(); //to ensure integer not entered

        try {
            for (int i = 0; i < postfix.length(); i++) {
                char ch = postfix.charAt(i);

                if (Character.isLetterOrDigit(ch)) {
                    stack.push(ch + "");
                } else {
                    if (stack.size() < 2) {
                        throw new Exception("Invalid Expression");
                    }

                    String op2 = stack.pop();
                    String op1 = stack.pop();

                    stack.push("(" + op1 + ch + op2 + ")");
                }
            }

            result = stack.pop();
            System.out.println("Converted: " + result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class DisplayThread extends Thread {
    ConvertThread ct;

    DisplayThread(ConvertThread ct) {
        this.ct = ct;
    }

    public void run() {
        try {
            ct.join();
        } catch (Exception e) {}

        System.out.println("Done.");
    }
}

public class PolishNotation {
    public static void main(String[] args) {
        ConvertThread t1 = new ConvertThread("AB*CD/+");
        DisplayThread t2 = new DisplayThread(t1);

        t1.start();
        t2.start();
    }
}
