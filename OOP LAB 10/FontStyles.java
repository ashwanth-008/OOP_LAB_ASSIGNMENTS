import java.awt.*;
import javax.swing.*;

public class FontStyles extends JFrame {

    public FontStyles() {
        setTitle("Font Styles");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setFont(new Font("Serif", Font.PLAIN, 20));
        g.drawString("Your Name", 50, 100);

        g.setFont(new Font("SansSerif", Font.BOLD, 30));
        g.drawString("Your Name", 50, 150);

        g.setFont(new Font("Monospaced", Font.ITALIC, 40));
        g.drawString("Your Name", 50, 220);
    }

    public static void main(String[] args) {
        new FontStyles();
    }
}