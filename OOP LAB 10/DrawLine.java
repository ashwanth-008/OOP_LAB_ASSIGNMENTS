import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawLine extends JFrame {
    int x1, y1, x2, y2;

    public DrawLine() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                repaint();
            }
        });

        setTitle("Draw Line");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(x1, y1, x2, y2);
    }

    public static void main(String[] args) {
        new DrawLine();
    }
}
