import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class DigitalClock extends JFrame {
    JLabel label;

    public DigitalClock() {
        label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        add(label);

        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        setTitle("Digital Clock");
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        label.setText(sdf.format(new Date()));
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}