import java.util.Scanner;

public class GameDriver {
    
    private Player p1;
    private Player p2;
    private GameBoard p1Board;
    private GameBoard p2Board;
    private Player winner;
    private StartMenu start;
    private char currentType;
    
    public GameDriver() {
        p1 = new Player(0);
        p2 = new Player(1);
        
        
        
        }
    

    public void play(){

        start = new StartMenu();
        boolean moveOn = false;
        while(!moveOn){
            moveOn = start.isClosed();
            System.out.print("");
        }
        System.out.println("Player 1: Please enter your username.");
        
        boolean validName = false;
        while(!validName){
            validName = p1.setUsername();
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("Player 2: Please enter your username.");
        
        validName = false;
        while(!validName){
            validName = p2.setUsername();
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();

        p1.setShipLocations();

        System.out.print("\033[H\033[2J");
        System.out.flush();


        p2.setShipLocations();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        boolean gameOver = false;

        p1Board = new GameBoard(p1.getBoard().getBoard(), p1.getShipList());
        p2Board = new GameBoard(p2.getBoard().getBoard(), p2.getShipList());

        while(!gameOver){

            p2Board.showBoard();
            
            Scanner sc = new Scanner(System.in);
            System.out.println(p1.getName()+", choose your target.");
            String input = "";
            
            
            int valid = -1;

            while(valid == -1){
                input = sc.nextLine();
                valid = p2.getBoard().targetLocation(input);
            }

            if (valid == 1){
                p2.updateShips(input);
            }
            
            p1.addHit(valid);
            p1.addShot();
            gameOver = p2.getBoard().gameState();
            System.out.println("Press enter to continue");
            input = sc.nextLine();


            p2Board.close();
            p2Board.updateBoard(p2.getBoard().getHits());

            System.out.print("\033[H\033[2J");
            System.out.flush();

            p1Board.showBoard();
            

            System.out.println(p2.getName()+", choose your target.");
            
            
            valid = -1;

            while(valid == -1){
                input = sc.nextLine();
                valid = p1.getBoard().targetLocation(input);
            }
            
            if (valid == 1){
                p1.updateShips(input);
            }

            p2.addHit(valid);
            p2.addShot();
            
            if(!gameOver){gameOver = p1.getBoard().gameState();}
            

            System.out.println("Press enter to continue");
            input = sc.nextLine();

            p1Board.close();
            p1Board.updateBoard(p1.getBoard().getHits());

            System.out.print("\033[H\033[2J");
            System.out.flush();


        }

        if(p2.getBoard().gameState()){
            winner = p1;
        }
        else{
            winner = p2;
        }

        System.out.println(winner.getName() + " wins! Long live the " + winner.getTeam() + "!");
        
    }

    
}