import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovingText extends JFrame implements KeyListener {
    String text = "";
    int x = 400;

    public MovingText() {
        addKeyListener(this);
        setFocusable(true);

        Timer timer = new Timer(100, e -> {
            x -= 5;
            if (x < -100) x = getWidth();
            repaint();
        });
        timer.start();

        setTitle("Moving Text");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(text, x, 150);
    }

    public void keyTyped(KeyEvent e) {
        text += e.getKeyChar();
    }

    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        new MovingText();
    }
}
