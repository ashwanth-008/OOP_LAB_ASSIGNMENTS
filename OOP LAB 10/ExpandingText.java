import java.awt.*;
import javax.swing.*;

public class ExpandingText extends JFrame {
    int size = 6;
    boolean growing = true;

    public ExpandingText() {
        Timer timer = new Timer(100, e -> {
            if (growing) size += 2;
            else size -= 2;

            if (size >= 96) growing = false;
            if (size <= 6) growing = true;

            repaint();
        });
        timer.start();

        setTitle("Expanding Text");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("Arial", Font.BOLD, size));
        g.drawString("HELLO", 100, 150);
    }

    public static void main(String[] args) {
        new ExpandingText();
    }
}