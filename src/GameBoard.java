import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;

public class GameBoard {
    final int width = 1000;
    final int height = 1000;
    JFrame frame;
    JPanel board;

    public GameBoard() {
        frame = new JFrame("Battleship");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        board = new JPanel();
        board.setLayout(new GridLayout(11, 11));

        ImageIcon one = new ImageIcon("Star Wars images/1.png");
        ImageIcon two = new ImageIcon("Star Wars images/2.png");
        ImageIcon three = new ImageIcon("Star Wars images/3.png");
        ImageIcon four = new ImageIcon("Star Wars images/4.png");
        ImageIcon five = new ImageIcon("Star Wars images/5.png");
        ImageIcon six = new ImageIcon("Star Wars images/6.png");
        ImageIcon sev = new ImageIcon("Star Wars images/7.png");
        ImageIcon eight = new ImageIcon("Star Wars images/8.png");
        ImageIcon nine = new ImageIcon("Star Wars images/9.png");
        ImageIcon ten = new ImageIcon("Star Wars images/10.png");

        

        for(int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++) {
                if(i == 0) {                    
                    switch(j) {
                        case 1: board.add(new JButton(one)); break;
                        case 2: board.add(new JButton(two)); break;
                        case 3: board.add(new JButton(three)); break;
                        case 4: board.add(new JButton(four)); break;
                        case 5: board.add(new JButton(five)); break;
                        case 6: board.add(new JButton(six)); break;
                        case 7: board.add(new JButton(sev)); break;
                        case 8: board.add(new JButton(eight)); break;
                        case 9:board.add(new JButton(nine)); break;
                        case 10: board.add(new JButton(ten)); break;

                    }
                }
                JButton button = new JButton();
                button.setBorder(BorderFactory.createLineBorder(Color.yellow));
                button.setBackground(Color.black);
                button.setOpaque(true);
                board.add(button);
            }
            
        }
        frame.add(board, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
