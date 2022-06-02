import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Carrier {
    final int width = 500;
    final int height = 100;
    JFrame frame;
    JPanel board;
    ImageIcon[] hitSquareIcons;
    JButton[] squares;

    public Carrier() {
        squares = new JButton[5];
        Ship aircraftCarrier = new Ship(0, 0, 5, 0, "h", 0);
        frame = new JFrame("Battleship");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hitSquareIcons = new ImageIcon[5];

        board = new JPanel();
        board.setLayout(new GridLayout(1, 5));

        for(int i = 0; i < 5; i++) {
            hitSquareIcons[i] = aircraftCarrier.getImage(i);
            squares[i] = new JButton(hitSquareIcons[i]);
        }

        for(int j = 0; j < 5; j++) {
            board.add(squares[j]);
        }

        frame.add(board);
        frame.setVisible(true);
    }

}