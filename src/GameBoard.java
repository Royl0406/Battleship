import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GameBoard {
    final int width = 1100;
    final int height = 1100;
    JFrame frame;
    JPanel board;
    JButton[][] squares;
    char[][] playerBoard;
    char[][] hitBoard;
    ArrayList<Ship> shipList;
    ImageIcon[][] hitSquareIcons;
    

    
    
    //for playerBoard, pass in location char[][], shipList from GameSetup.java
    public GameBoard(char[][] inputBoard, ArrayList<Ship> shipList) {
        playerBoard = new char[10][10];
        
        for(int row = 0; row < 10; row++) {
            for(int col = 0; col < 10; col++) {
                playerBoard[row][col] = inputBoard[row][col];
            }
        }
        
        this.shipList = shipList;

        frame = new JFrame("Battleship");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new JPanel();
        board.setLayout(new GridLayout(11, 11));
        hitSquareIcons = new ImageIcon[10][10];

        hitBoard = new char[10][10];
        //make sure board is clean/unhit
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                hitBoard[i][j] = '0';
            }
        }
        
        squares = new JButton[11][11];
        for(int r = 0; r < 11; r++) {
            for(int c = 0; c < 11; c++) {
                squares[r][c] = new JButton();
                squares[r][c].setBorder(BorderFactory.createLineBorder(Color.yellow));
                squares[r][c].setBackground(Color.black);
                squares[r][c].setOpaque(true);
            }
        }
        
    }

    //show board with shots updated
    public void showBoard() {
        board.removeAll();
        board.repaint();
        board.revalidate();
        board.setLayout(new GridLayout(11, 11));

        ImageIcon zero = new ImageIcon("Star Wars images/0.png");
        ImageIcon one = new ImageIcon("Star Wars images/1.png");
        ImageIcon two = new ImageIcon("Star Wars images/2.png");
        ImageIcon three = new ImageIcon("Star Wars images/3.png");
        ImageIcon four = new ImageIcon("Star Wars images/4.png");
        ImageIcon five = new ImageIcon("Star Wars images/5.png");
        ImageIcon six = new ImageIcon("Star Wars images/6.png");
        ImageIcon sev = new ImageIcon("Star Wars images/7.png");
        ImageIcon eight = new ImageIcon("Star Wars images/8.png");
        ImageIcon nine = new ImageIcon("Star Wars images/9.png");

        ImageIcon A = new ImageIcon("Star Wars images/A.png");
        ImageIcon B = new ImageIcon("Star Wars images/B.png");
        ImageIcon C = new ImageIcon("Star Wars images/C.png");
        ImageIcon D = new ImageIcon("Star Wars images/D.png");
        ImageIcon E = new ImageIcon("Star Wars images/E.png");
        ImageIcon F = new ImageIcon("Star Wars images/F.png");
        ImageIcon G = new ImageIcon("Star Wars images/G.png");
        ImageIcon H = new ImageIcon("Star Wars images/H.png");
        ImageIcon I = new ImageIcon("Star Wars images/I.png");
        ImageIcon J = new ImageIcon("Star Wars images/J.png");

        // adding labels for each column (1-10)
        for (int i = 0; i < 11; i++) {
            switch (i) {
                case 1:
                    board.add(new JButton(zero));
                    break;
                case 2:
                    board.add(new JButton(one));
                    break;
                case 3:
                    board.add(new JButton(two));
                    break;
                case 4:
                    board.add(new JButton(three));
                    break;
                case 5:
                    board.add(new JButton(four));
                    break;
                case 6:
                    board.add(new JButton(five));
                    break;
                case 7:
                    board.add(new JButton(six));
                    break;
                case 8:
                    board.add(new JButton(sev));
                    break;
                case 9:
                    board.add(new JButton(eight));
                    break;
                case 10:
                    board.add(new JButton(nine));
                    break;

            }
        }

        //initializing all the buttons
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == 0 && j == 0) {
                    JButton button = new JButton();
                    button.setBorder(BorderFactory.createLineBorder(Color.yellow));
                    button.setBackground(Color.black);
                    button.setOpaque(true);
                    board.add(button);
                    break;
                }
                // adding labels for each rows (A-J)
                if (i != 0 && j == 10) {
                    switch (i) {
                        case 1:
                            board.add(new JButton(A));
                            break;
                        case 2:
                            board.add(new JButton(B));
                            break;
                        case 3:
                            board.add(new JButton(C));
                            break;
                        case 4:
                            board.add(new JButton(D));
                            break;
                        case 5:
                            board.add(new JButton(E));
                            break;
                        case 6:
                            board.add(new JButton(F));
                            break;
                        case 7:
                            board.add(new JButton(G));
                            break;
                        case 8:
                            board.add(new JButton(H));
                            break;
                        case 9:
                            board.add(new JButton(I));
                            break;
                        case 10:
                            board.add(new JButton(J));
                            break;

                    }
                    break;
                }
                
                //display the corresponding image when the square has been hit
                if(hitBoard[i-1][j] != '0') {
                    switch (hitBoard[i-1][j]) {
                        //hit target
                        case '1':
                            String shipName = typeCharToFullType(playerBoard[i-1][j]);


                            for(int k = 0; k < shipList.size(); k++) {
                                Ship s = shipList.get(k);
                               
                                if(s.getType().equals(shipName)) {
                                    
                                    //check if horizontal or vertical
                                    if(s.getOrient().equals("h")) {
    

                                        hitSquareIcons[i-1][j] = s.getImage(j - s.getCol());
                                    } 
                                    else {    
                                    
                                            int test = i - 1 - s.getRow();
                                            System.out.println(test);
                                            hitSquareIcons[i-1][j] = s.getImage(i - 1 - s.getRow());
                                    }
                                }
                                
                                
                            }
                            break;
                        case '2':
                            hitSquareIcons[i-1][j] = new ImageIcon("Misc images/missedSquare.png");
                            break;
                    }
                    squares[i][j] = new JButton(hitSquareIcons[i-1][j]);
                    
                    
                }
                
                board.add(squares[i][j]);
                
            }

        }
        //add the entire board to the frame and display the frame
        frame.add(board, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    //close the GUI
    public void close() {
        frame.setVisible(false);
    }

    //add new hits to the board
    public void updateBoard(char[][] updatedBoard) {
        hitBoard = updatedBoard;
    
    }

    public String typeCharToFullType(char type) {
        switch(type) {
            case 'a':
                return "Aircraft Carrier";
            case 'b':
                return "Battleship";
            case 'd':
                return "Destroyer";
            case 's':
                return "Submarine";
            case 'p':
                return "Patrol Boat";
            default: return "";
        }

    }
}
