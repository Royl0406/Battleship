import javax.swing.*;
import java.awt.*;

public class GameBoard {
    final int width = 500;
    final int height = 500;
    JFrame frame;
    public GameBoard() {
        frame = new JFrame("Battleship");
        frame.setSize(width, height);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
    }
}
