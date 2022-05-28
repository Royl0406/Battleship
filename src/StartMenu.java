import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartMenu implements ActionListener{
    final int width = 1100;
    final int height = 1100;
        
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    boolean closed = false;

    public StartMenu() {
        
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ImageIcon logoImg = new ImageIcon("Misc images/start_image.png");
        ImageIcon playImg = new ImageIcon("Misc images/play.png");
        

        
        JLabel pic = new JLabel(logoImg);
        JButton play = new JButton("Play");
        
        play.setPreferredSize(new Dimension(200, 100));
        play.setBackground(Color.YELLOW);
        play.setOpaque(true);
        play.addActionListener(this);
        
                
        panel.add(pic);
        panel.add(play);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true );

        Music theme = new Music();
        


    }

    public void actionPerformed(ActionEvent e){  
        frame.setVisible(false);
        closed = true;
        //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }  

    public boolean isClosed() {
        return closed;
    }


}  
