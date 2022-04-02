import javax.swing.*;
import java.awt.*;

public class GameBoard {
    final int width = 1000;
    final int height = 1000;
    JFrame frame;
    public GameBoard() {
        frame = new JFrame("Battleship");
        frame.setSize(width, height);
        frame.getContentPane().setLayout(new GridLayout(10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int i = 0; i < 100; i++) {
            JButton button = new JButton();
            button.setBorder(BorderFactory.createLineBorder(Color.yellow));
            button.setBackground(Color.black);
            button.setOpaque(true);
            frame.add(button);
        }

        frame.setVisible(true);
    }
}
