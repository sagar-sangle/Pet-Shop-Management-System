package petshop;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow {
    
    private JProgressBar progressBar;
    private int progress;
    private Timer timer;

    public SplashScreen() {
        setLayout(new BorderLayout());
        
        // create label with "Happy Pets" text at the top
        JLabel label = new JLabel(" Heaven Pets", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 34));
           label.setForeground(new java.awt.Color(255, 0, 103));
        add(label, BorderLayout.NORTH);
        
        // create panel with cat and dog images at the center
        JPanel centerPanel = new JPanel(new FlowLayout());
        ImageIcon catIcon = new ImageIcon(getClass().getResource("catdog.png"));
       
        
        catIcon = new ImageIcon(catIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
      
        
        JLabel catLabel = new JLabel(catIcon);
     
        centerPanel.add(catLabel);
     
        add(centerPanel, BorderLayout.CENTER);
        
        // create progress bar at the bottom
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        add(progressBar, BorderLayout.SOUTH);
        
        // set the size and position of the window
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - 400) / 2;
        int y = (screen.height - 300) / 2;
        setBounds(x, y, 500, 300);
        
        // start the timer for 3 seconds
        timer = new Timer(30, e -> {
            progress++;
            progressBar.setValue(progress);
            if (progress == 100) {
                timer.stop();
                 new LogIn().setVisible(true);
                dispose();
                
                    
                
            }
        });
        timer.start();
        
        // show the window
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new SplashScreen();
    }
}
