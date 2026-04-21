import java.awt.*;
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;

public class ImageAudioApp extends JPanel {
    Image img;
    Clip clip;

    public ImageAudioApp() {
        // Load Image
        img = new ImageIcon("C:\\Users\\Ashwanth\\Desktop\\OOP LAB 10\\circutit.png").getImage();

        // Load Audio
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("C:\\Users\\Ashwanth\\Desktop\\OOP LAB 10\\ArabianNights_96_G#m_Flute_4bars.wav"));
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.loop(Clip.LOOP_CONTINUOUSLY); // loop audio
        } catch (Exception e) {
            System.out.println("Audio error: " + e);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 50, 50, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image + Audio");
        frame.add(new ImageAudioApp());
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}