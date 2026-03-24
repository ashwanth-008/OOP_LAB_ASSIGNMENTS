import java.io.*;

public class ReplaceHim {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Ashwanth\\Desktop\\OOP LAB 8\\REPLACEHIM.txt");

        try {
            // Read file using FileReader
            FileReader fr = new FileReader(file);
            String content = "";
            int ch;

            while ((ch = fr.read()) != -1) {
                content += (char) ch;  // append character to string
            }
            fr.close();

            // Replace all occurrences of "his" with "her"
            String[] words = content.split("\\s"); // split by whitespace
            String result = "";
            for (String word : words) {
                // Check for "his" in any case
                if (word.equalsIgnoreCase("his")) {
                    result += "her";
                } else {
                    result += word;
                }
                result += " "; // add space back
            }

            // Write back using FileWriter
            FileWriter fw = new FileWriter(file);
            fw.write(result);
            fw.close();

            System.out.println("Replacement done successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please make sure sdj.txt exists.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
