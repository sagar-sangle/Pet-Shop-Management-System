import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class PetShopSplashPage extends JPanel {

    private static final long serialVersionUID = 1L;
    private JProgressBar progressBar;
    private int progress;

    public PetShopSplashPage() {
        setLayout(null);
        progressBar = new JProgressBar();
        progressBar.setMaximum(100);
        progressBar.setBounds(10, 220, 460, 20);
        add(progressBar);
    }

    public void updateProgressBar(int value) {
        progress = value;
        progressBar.setValue(progress);
        progressBar.setStringPainted(true);
        progressBar.setString(progress + "%");
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 480, 250);
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Welcome to Pet Shop!", 110, 60);
        ImageIcon icon = new ImageIcon("petshop.png");
        icon.paintIcon(this, g, 180, 80);
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("Loading...", 210, 200);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pet Shop Splash Page");
        PetShopSplashPage splashPage = new PetShopSplashPage();
        frame.setContentPane(splashPage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 250);
        frame.setVisible(true);
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            splashPage.updateProgressBar(i);
        }
        
        // Here you can add the code to start your main application
    }

}
