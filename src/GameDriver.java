import java.util.Scanner;

public class GameDriver {
    
    private Player p1;
    private Player p2;
    
    public GameDriver() {
        p1 = new Player(0);
        p2 = new Player(1);
        
        }
    

    public void play(){

        System.out.println("Player 1: Please enter your username.");
        
        boolean validName = false;
        while(!validName){
            validName = p1.setUsername();
        }
        
        System.out.println("Player 2: Please enter your username.");
        
        validName = false;
        while(!validName){
            validName = p2.setUsername();
        }

        p1.setShipLocations();
        p2.setShipLocations();

        boolean gameOver = false;

        while(!gameOver){

            Scanner sc = new Scanner(System.in);
            System.out.println(p1.getName()+", choose your target.");
            String input = sc.nextLine();
            p2.getBoard().targetLocation(input);
            gameOver = p2.getBoard().gameState();

            System.out.println(p2.getName()+", choose your target.");
            input = sc.nextLine();
            p1.getBoard().targetLocation(input);
            gameOver = p1.getBoard().gameState();


        }
        
    }

    
}